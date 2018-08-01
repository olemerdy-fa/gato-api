package com.financeactive.gatoapi.core.stuff;

import com.github.javafaker.Faker;
import org.javamoney.moneta.Money;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.Clock;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@Component
public class StuffGen implements Supplier<Stuff> {

    private final Clock clock;

    private final Faker faker;

    private final Supplier<Money> moneySupplier;

    public StuffGen(Clock clock, Faker faker, Supplier<Money> moneySupplier) {
        this.clock = clock;
        this.faker = faker;
        this.moneySupplier = moneySupplier;
    }

    @Override
    public Stuff get() {
        return new Stuff(
                UUID.randomUUID(),
                faker.date().past(1_000, TimeUnit.DAYS, Date.from(clock.instant())).toInstant(),
                faker.book().title(),
                faker.lorem().paragraph(),
                moneySupplier.get()
        );
    }
}
