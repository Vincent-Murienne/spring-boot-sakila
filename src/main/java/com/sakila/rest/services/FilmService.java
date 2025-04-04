package com.sakila.rest.services;

import com.sakila.rest.entities.Film;

import java.util.List;

public interface FilmService extends IService<Film, Integer> {
    List<Film> findByActorId(Integer actorId);
    List<Film> findByTitleContaining(String title);
}
