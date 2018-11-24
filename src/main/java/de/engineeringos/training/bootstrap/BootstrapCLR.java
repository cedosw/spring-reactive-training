package de.engineeringos.training.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import de.engineeringos.training.domain.Movie;
import de.engineeringos.training.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
@Slf4j
class BootstrapCLR implements CommandLineRunner {
    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        // clear old data
        movieRepository.deleteAll().block();

        Flux.just("The fast and the furios", "Transporter", "Ironman 3", "Lord of the rings")
                .map(title -> new Movie(title)).flatMap(movieRepository::save)
                .subscribe(null, null, () -> {
                    movieRepository.findAll().subscribe(m -> log.info(m.toString()));
                });
    }

}
