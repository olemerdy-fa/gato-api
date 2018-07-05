package com.financeactive.gatoapi.rest.security;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Component
public class HeaderJwtExtractor implements JwtExtractor {

    private static final String BEARER = "Bearer ";

    @Override
    public Optional<String> extractJwt(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader("Authorization"))
                .filter(auth -> auth.startsWith(BEARER))
                .map(auth -> auth.substring(BEARER.length()));
    }
}
