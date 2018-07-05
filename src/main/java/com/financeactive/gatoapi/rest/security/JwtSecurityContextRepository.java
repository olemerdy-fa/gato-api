package com.financeactive.gatoapi.rest.security;

import com.auth0.spring.security.api.BearerSecurityContextRepository;
import com.auth0.spring.security.api.authentication.PreAuthenticatedAuthenticationJsonWebToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Component
public class JwtSecurityContextRepository implements SecurityContextRepository {

    private final static Logger logger = LoggerFactory.getLogger(BearerSecurityContextRepository.class);

    private final List<JwtExtractor> extractors;

    public JwtSecurityContextRepository(List<JwtExtractor> extractors) {
        this.extractors = extractors;
    }

    @Override
    public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        String token = tokenFromRequest(requestResponseHolder.getRequest());
        Authentication authentication = PreAuthenticatedAuthenticationJsonWebToken.usingToken(token);
        if (authentication != null) {
            context.setAuthentication(authentication);
            logger.debug("Found bearer token in request. Saving it in SecurityContext");
        }
        return context;
    }

    @Override
    public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    public boolean containsContext(HttpServletRequest request) {
        return tokenFromRequest(request) != null;
    }

    private String tokenFromRequest(HttpServletRequest request) {
        return extractors.stream()
                .map(extractor -> extractor.extractJwt(request))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findAny()
                .orElse(null);
    }
}
