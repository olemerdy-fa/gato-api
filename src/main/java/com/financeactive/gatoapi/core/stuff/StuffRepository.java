package com.financeactive.gatoapi.core.stuff;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

@Repository
public class StuffRepository {

    private final StuffGen generator;

    private final Set<Stuff> values;

    public StuffRepository(StuffGen generator) {
        this.generator = generator;
        this.values = new LinkedHashSet<>();
    }

    @PostConstruct
    void init() {
        Stream.generate(generator).limit(100).forEach(values::add);
    }

    public Collection<Stuff> findAll() {
        return Collections.unmodifiableCollection(values);
    }
}
