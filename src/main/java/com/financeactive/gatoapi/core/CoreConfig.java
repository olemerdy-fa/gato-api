package com.financeactive.gatoapi.core;

import com.fasterxml.jackson.databind.Module;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.jackson.datatype.money.MoneyModule;

import java.time.Clock;

@Configuration
public class CoreConfig {

    @Bean
    Clock clock() {
        return Clock.systemDefaultZone();
    }

    @Bean
    Faker faker() {
        return new Faker();
    }

    @Bean
    Module moneyModule() {
        return new MoneyModule();
    }
}
