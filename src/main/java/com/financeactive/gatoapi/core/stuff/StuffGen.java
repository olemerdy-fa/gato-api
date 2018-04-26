package com.financeactive.gatoapi.core.stuff;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.Instant;
import java.util.UUID;
import java.util.function.Supplier;

@Component
public class StuffGen implements Supplier<Stuff> {

    private final Clock clock;

    private final Faker faker;

    public StuffGen(Clock clock, Faker faker) {
        this.clock = clock;
        this.faker = faker;
    }

    @Override
    public Stuff get() {
        return new Stuff(
                UUID.randomUUID(),
                Instant.now(clock),
                faker.book().title(),
                faker.lorem().paragraph()
        );
    }
}
