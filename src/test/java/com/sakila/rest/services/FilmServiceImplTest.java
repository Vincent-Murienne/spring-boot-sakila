package com.sakila.rest.services;

import com.sakila.rest.repositories.FilmRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FilmServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(FilmServiceImplTest.class);

    @Autowired
    FilmService service;

    @Autowired
    FilmRepository repository;

    @Test
    void readAll() {
        log.info("<<<<<<readAll START>>>>>>");
        var films = service.readAll();
        films.forEach(f->log.trace("{}",f));
        log.info("Nbre de films : {}",films.size());
        log.info("<<<<<<readAll STOP >>>>>>");
    }

    @Test
    void readAllByActor() {
        log.info("<<<<<<readAllByActor START>>>>>>");
        var films = service.findByActorId(1);
        films.forEach(f->log.info("{}",f));
        log.info("Nbre d'acteurs : {}",films.size());
        log.info("<<<<<<readAllByActor STOP >>>>>>");
    }
}
