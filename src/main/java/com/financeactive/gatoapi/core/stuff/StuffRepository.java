package com.financeactive.gatoapi.core.stuff;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

@Repository
public class StuffRepository {

    private final StuffGen generator;

    public StuffRepository(StuffGen generator) {
        this.generator = generator;
    }

    @Cacheable("stuff")
    public Collection<Stuff> findAll() {
        return Stream.generate(generator).limit(100).collect(toSet());
    }
}
