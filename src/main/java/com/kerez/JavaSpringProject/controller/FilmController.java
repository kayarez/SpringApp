package com.kerez.JavaSpringProject.controller;

import com.kerez.JavaSpringProject.model.Film;
import com.kerez.JavaSpringProject.service.impl.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class FilmController {
    @Autowired
    FilmService filmService;

    @GetMapping("film")
    public List<Film> getAllFilms(){
        return filmService.GetAllFilms();
    }
    @PostMapping("film")
    public Film saveFilm(@RequestBody Film film){
        return filmService.saveFilm(film);
    }

}
