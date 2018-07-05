package com.financeactive.gatoapi.rest.security;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class CookieJwtExtractor implements JwtExtractor {

    private final String tokenCookieName;

    public CookieJwtExtractor(String tokenCookieName) {
        this.tokenCookieName = tokenCookieName;
    }

    public Optional<String> extractJwt(HttpServletRequest request) {
        if (request.getCookies() == null) {
            return Optional.empty();
        }
        return Stream.of(request.getCookies())
                .filter(cookie -> tokenCookieName.equalsIgnoreCase(cookie.getName()))
                .map(Cookie::getValue)
                .filter(Objects::nonNull)
                .filter(s -> s.trim().length() > 0)
                .findAny();
    }
}