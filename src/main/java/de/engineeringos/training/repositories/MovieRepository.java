package de.engineeringos.training.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import de.engineeringos.training.domain.Movie;

@Repository
public interface MovieRepository extends ReactiveMongoRepository<Movie, String>{

}
