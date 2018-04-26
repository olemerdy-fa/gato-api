package com.financeactive.gatoapi.rest.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SecurityController {

    @GetMapping("user")
    public Principal user(Principal principal) {
        return principal;
    }

}
