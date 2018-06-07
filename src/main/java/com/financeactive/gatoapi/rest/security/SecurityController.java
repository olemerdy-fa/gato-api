package com.financeactive.gatoapi.rest.security;

import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@CrossOrigin
@RestController
public class SecurityController {

    @GetMapping("user")
    public Map<String, Object> user(Principal principal) {
        return ImmutableMap.of("name", principal.getName());
    }

}
