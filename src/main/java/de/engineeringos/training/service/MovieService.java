package de.engineeringos.training.service;

import de.engineeringos.training.domain.Movie;
import de.engineeringos.training.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {
    
    Flux<MovieEvent> getEventsByMovieId(String movieId);
    
    Mono<Movie> getMovieById(String id);
    
    Flux<Movie> getAllMovies();

}
