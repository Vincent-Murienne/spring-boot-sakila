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

    @Test
    void read() {
        log.info("<<<<<<<read by Id START>>>>>>>");
        var actor = actorService.read(2);
        log.trace("{}", actor);
        log.info("<<<<<<<read by Id END >>>>>>>");
    }

    @Test
    void readAll() {
        log.info("<<<<<<<readAll START>>>>>>>");
        var actors = actorService.readAll();
        actors.forEach(c->log.trace("{}", c));
        log.info("Nbre d'acteurs : {}"
                , actors.size() );
        assertEquals(200, actors.size(),0,"Nbre d'actors ERRONE : " + actors.size());
        log.info("<<<<<<<readAll END>>>>>>>");
    }
}