package com.financeactive.gatoapi.rest.security;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${auth0.apiAudience}")
    private String apiAudience;

    @Value("${auth0.issuer}")
    private String issuer;

    @Autowired
    private SecurityContextRepository securityContextRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtWebSecurityConfigurer
                .forRS256(apiAudience, issuer)
                .configure(http)
                .securityContext()
                .securityContextRepository(securityContextRepository)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/user").fullyAuthenticated()
                .anyRequest().permitAll();
    }

    @Bean
    @ConditionalOnProperty("jwt.cookie.name")
    JwtExtractor cookieJwtExtractor(@Value("${jwt.cookie.name}") String jwtCookieName) {
        return new CookieJwtExtractor(jwtCookieName);
    }
}
