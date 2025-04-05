package com.sakila.rest.services;

import com.sakila.rest.entities.Actor;

import java.util.List;

public interface ActorService extends IService<Actor, Integer> {
    List<Actor> findByFirstNameContaining(String firstName);
    List<Actor> findByLastNameContaining(String lastName);
    List<Actor> findByNameContaining(String name);
    List<Actor> findByFilmId(Integer film_id);
}