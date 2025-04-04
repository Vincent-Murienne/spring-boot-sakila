package com.sakila.rest.services;

import com.sakila.rest.entities.Film;
import com.sakila.rest.repositories.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository repository;

    public FilmServiceImpl(FilmRepository repository) {
        this.repository = repository;
    }

    @Override
    public Film create(Film obj) {
        return null;
    }

    @Override
    public Film read(Integer id) {
        return null;
    }

    @Override
    public Film update(Film obj) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<Film> readAll() {
        return repository.findAll();
    }
}
