package de.engineeringos.training.service;

import java.time.Duration;
import java.util.Date;

import org.springframework.stereotype.Service;

import de.engineeringos.training.domain.Movie;
import de.engineeringos.training.domain.MovieEvent;
import de.engineeringos.training.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Flux<MovieEvent> getEventsByMovieId(String movieId) {
        return Flux.<MovieEvent>generate(movieEventSynchronousSink -> {
            movieEventSynchronousSink.next(new MovieEvent(movieId, new Date()));
        }).delayElements(Duration.ofSeconds(1));
    }

    @Override
    public Mono<Movie> getMovieById(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public Flux<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

}
