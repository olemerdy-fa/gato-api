package com.financeactive.gatoapi.rest;

import com.financeactive.gatoapi.core.stuff.Stuff;
import com.financeactive.gatoapi.core.stuff.StuffRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("stuff")
public class StuffController {

    private final StuffRepository repository;

    public StuffController(StuffRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Collection<Stuff> getAll() {
        return repository.findAll();
    }
}
