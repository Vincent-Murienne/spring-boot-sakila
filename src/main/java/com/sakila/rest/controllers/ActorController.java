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

    /** localhost:9094/sakila/actor/all || /** localhost:9094/sakila/city */
    @GetMapping(value = {"", "/all"})
    @Transactional
    public List<Actor> getAllActors() {
        return service.readAll();
    }

    /** localhost:9094/sakila/actor/get/{id} */
    @GetMapping("/get/{id}")
    @Transactional
    public Actor getActorById(@PathVariable("id") Integer id) {
        return service.read(id);
    }

    /** localhost:9094/sakila/actor/search/firstname/{name} */
    @GetMapping("/search/firstname/{name}")
    @Transactional
    public List<Actor> searchByFirstName(@PathVariable("name") String name) {
        return service.findByFirstNameContaining(name);
    }

    /** localhost:9094/sakila/actor/search/lastname/{name} */
    @GetMapping("/search/lastname/{name}")
    @Transactional
    public List<Actor> searchByLastName(@PathVariable("name") String name) {
        return service.findByLastNameContaining(name);
    }

    /** localhost:9094/sakila/actor/search/{name} */
    @GetMapping("/search/{name}")
    @Transactional
    public List<Actor> searchByName(@PathVariable("name") String name) {
        return service.findByNameContaining(name);
    }
}