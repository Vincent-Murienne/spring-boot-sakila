package com.sakila.rest.services;

import com.sakila.rest.entities.Actor;
import com.sakila.rest.repositories.ActorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    private static final Logger log = LoggerFactory.getLogger(ActorServiceImpl.class);

    // Ne plus mettre de @Autowired
    private final ActorRepository actorRepository; // toujours mettre final (pour être sûr que la valeur ne change pas)

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
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
}
