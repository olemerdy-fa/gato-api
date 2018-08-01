package com.financeactive.gatoapi.core.money;

import com.github.javafaker.Faker;
import org.javamoney.moneta.Money;
import org.springframework.stereotype.Component;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import java.util.function.Supplier;

@Component
public class MoneyGen implements Supplier<Money> {

    private final Faker faker;

    public MoneyGen(Faker faker) {
        this.faker = faker;
    }

    @Override
    public Money get() {
        CurrencyUnit currency = Monetary.getCurrency(faker.currency().code());
        double amount = faker.number().randomDouble(currency.getDefaultFractionDigits(), 0, Integer.MAX_VALUE);
        return Money.of(amount, currency);
    }
}
