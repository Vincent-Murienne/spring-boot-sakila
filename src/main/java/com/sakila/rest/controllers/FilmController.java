package com.sakila.rest.controllers;

import com.sakila.rest.entities.Film;
import com.sakila.rest.services.FilmService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {

    private final FilmService service;

    public FilmController(FilmService service) {
        this.service = service;
    }
    @GetMapping("/all")
    @Transactional
    public List<Film> getAllFilms() {
        return service.readAll();
    }

    /** localhost:9094/sakila/film/search/{title} */
    @GetMapping("/search/{title}")
    @Transactional
    public List<Film> searchByTitle(@PathVariable("title") String title) {
        return service.findByTitleContaining(title);
    }
}
