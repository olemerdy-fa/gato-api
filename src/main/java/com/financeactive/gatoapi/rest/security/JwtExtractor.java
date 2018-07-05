package com.financeactive.gatoapi.rest.security;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public interface JwtExtractor {

    Optional<String> extractJwt(HttpServletRequest request);
}
