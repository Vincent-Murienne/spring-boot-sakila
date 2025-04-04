package com.sakila.rest.repositories;

import com.sakila.rest.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    List<Actor> findByFirstNameContainingIgnoreCase(String firstName);
    List<Actor> findByLastNameContainingIgnoreCase(String lastName);
    List<Actor> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);
}
