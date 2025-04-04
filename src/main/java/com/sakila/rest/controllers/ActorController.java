package com.sakila.rest.controllers;

import com.sakila.rest.entities.Actor;
import com.sakila.rest.services.ActorService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    private final ActorService service;

    public ActorController(ActorService service) {
        this.service = service;
    }

    /** localhost:9093/sakila/actor/all || /** localhost:9093/sakila/city */
    @GetMapping(value = {"", "/all"})
    @Transactional
    public List<Actor> getAllActors() {
        return service.readAll();
    }

    /** localhost:9093/sakila/actor/get/{id} */
    @GetMapping("/get/{id}")
    @Transactional
    public Actor getActorById(@PathVariable("id") Integer id) {
        return service.read(id);
    }
}