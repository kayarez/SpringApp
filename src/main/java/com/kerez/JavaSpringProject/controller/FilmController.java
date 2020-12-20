package com.kerez.JavaSpringProject.controller;

import com.kerez.JavaSpringProject.OAP.Loggable;
import com.kerez.JavaSpringProject.model.Film;
import com.kerez.JavaSpringProject.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class FilmController {

    @Autowired
    FilmService filmService;

    @Loggable
    @GetMapping("/films")
    public List<Film> getFilms(){
        return filmService.getFilms();}



    @Loggable
    @PostMapping("/films")
    public Film saveFilm(@RequestBody Film model){
        return filmService.save(model);
    }

}
