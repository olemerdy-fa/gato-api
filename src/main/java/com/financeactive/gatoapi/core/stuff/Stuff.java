package com.financeactive.gatoapi.core.stuff;

import java.time.Instant;
import java.util.UUID;

public final class Stuff {

    private final UUID id;

    private final Instant creationDate;

    private final String title;

    private final String description;

    public Stuff(UUID id, Instant creationDate, String title, String description) {
        this.id = id;
        this.creationDate = creationDate;
        this.title = title;
        this.description = description;
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
}
