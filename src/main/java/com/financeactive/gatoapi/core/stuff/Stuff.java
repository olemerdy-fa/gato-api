package com.financeactive.gatoapi.core.stuff;

import org.javamoney.moneta.Money;

import java.time.Instant;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

public final class Stuff {

    private final UUID id;

    private final Instant creationDate;

    private final String title;

    private final String description;

    private final Money price;

    public Stuff(UUID id, Instant creationDate, String title, String description, Money money) {
        this.id = requireNonNull(id);
        this.creationDate = creationDate;
        this.title = requireNonNull(title);
        this.description = description;
        this.price = requireNonNull(money);
    }

    public UUID getId() {
        return id;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Money getPrice() {
        return price;
    }
}
