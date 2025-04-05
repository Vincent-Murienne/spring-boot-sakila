package com.sakila.rest.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ActorServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(ActorServiceImplTest.class);

    @Autowired
    ActorServiceImpl actorService ;

    @BeforeEach
    void setUp() {
    }

    /* Un acteur */
    @Test
    void read() {
        log.info("<<<<<<<read by Id START>>>>>>>");
        var actor = actorService.read(2);
        log.trace("{}", actor);
        log.info("<<<<<<<read by Id END >>>>>>>");
    }

    /* Tous les acteurs */
    @Test
    void readAll() {
        log.info("<<<<<<<readAll START>>>>>>>");
        var actors = actorService.readAll();
        actors.forEach(c->log.trace("{}", c));
        log.info("Nbre d'acteurs : {}", actors.size() );
        assertEquals(200, actors.size(),0,"Nbre d'actors ERRONE : " + actors.size());
        log.info("<<<<<<<readAll END>>>>>>>");
    }

    /* Acteurs pour un film */
    @Test
    void readAllByFilm() {
        log.info("<<<<<<readAllByFilm START>>>>>>");
        var actors = actorService.findByFilmId(1);
        actors.forEach(f->log.info("{}",f));
        log.info("Nbre de films : {}",actors.size());
        log.info("<<<<<<readAllByFilm STOP >>>>>>");
    }

    /* Recherche sur une partie du prénom des acteurs */
    @Test
    void searchByFirstName() {
        log.info("<<<<<<<searchByFirstName START>>>>>>>");
        var actors = actorService.findByFirstNameContaining("fu");
        actors.forEach(c->log.trace("{}", c));
        log.info("Nbre d'acteurs : {}",actors.size());
        log.info("<<<<<<<searchByFirstName END>>>>>>>");
    }

    /* Recherche sur une partie du nom des acteurs */
    @Test
    void searchByLastName() {
        log.info("<<<<<<<searchByLastName START>>>>>>>");
        var actors = actorService.findByLastNameContaining("li");
        actors.forEach(c->log.trace("{}", c));
        log.info("Nbre d'acteurs : {}",actors.size());
        log.info("<<<<<<<searchByLastName END>>>>>>>");
    }

    /* Recherche sur une partie du prénom et nom des acteurs */
    @Test
    void searchByNameAndLastNameContaining() {
        log.info("<<<<<<<searchByFirstNameAndLastNameContaining START>>>>>>>");
        var actors = actorService.findByNameContaining("pen");
        actors.forEach(c->log.trace("{}", c));
        log.info("Nbre d'acteurs : {}",actors.size());
        log.info("<<<<<<<searchByFirstNameAndLastNameContaining END>>>>>>>");
    }
}