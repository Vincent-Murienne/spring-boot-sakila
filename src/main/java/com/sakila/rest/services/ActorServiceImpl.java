package com.sakila.rest.services;

import com.sakila.rest.entities.Actor;
import com.sakila.rest.entities.Film;
import com.sakila.rest.repositories.ActorRepository;
import com.sakila.rest.repositories.FilmRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    private static final Logger log = LoggerFactory.getLogger(ActorServiceImpl.class);

    // Ne plus mettre de @Autowired
    private final ActorRepository actorRepository;
    private final FilmRepository filmRepository;

    public ActorServiceImpl(ActorRepository actorRepository, FilmRepository filmRepository) {
        this.actorRepository = actorRepository;
        this.filmRepository = filmRepository;
    }

    @Override
    public Actor create(Actor actor) {
        return null;
    }

    @Override
    public Actor read(Integer id) {
        return actorRepository.findById(id).orElse(null);
    }

    @Override
    public Actor update(Actor actor) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<Actor> readAll() {
        return actorRepository.findAll();
    }

    @Override
    public List<Actor> findByFirstNameContaining(String firstName) {
        return actorRepository.findByFirstNameContainingIgnoreCase(firstName);
    }

    @Override
    public List<Actor> findByLastNameContaining(String lastName) {
        return actorRepository.findByLastNameContainingIgnoreCase(lastName);
    }

    @Override
    public List<Actor> findByNameContaining(String name) {
        return actorRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name);
    }
}
