package com.example.movies.controller;

import com.example.movies.exception.ResourceNotFoundException;
import com.example.movies.model.Movie;
import com.example.movies.repository.MoviesRepository;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class MoviesController {

    @Autowired
    MoviesRepository moviesRepository;

    @GetMapping("/movie/{title}")
    public Movies getMovieByTitle(@PathVariable(value = "title") String movietitle){
        return moviesRepository.findByTitle( movietitle)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "title", movietitle));
    }

    @PostMapping("/movie")
    public Movies createMovie(@Valid @RequestBody Movies movies) {
        return moviesRepository.save(movies);
    }

    @GetMapping("/movie/{genre}")
    public Movies getMovieByGenre(@PathVariable(value = "genre") String moviegenre) {
        return moviesRepository.findByGenre(moviegenre)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "genre", moviegenre));
    }


}
