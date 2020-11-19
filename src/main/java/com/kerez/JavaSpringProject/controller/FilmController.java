package com.kerez.JavaSpringProject.controller;

import com.kerez.JavaSpringProject.OAP.Loggable;
import com.kerez.JavaSpringProject.model.FilmModel;
import com.kerez.JavaSpringProject.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilmController {

    @Autowired
    FilmService filmService;

    @Loggable
    @GetMapping("/films")
    public List<FilmModel> getFilms(){
        return filmService.getFilms();
    }

    @Loggable
    @PostMapping("/films")
    public FilmModel saveFilm(@RequestBody FilmModel model){
        return filmService.save(model);
    }
}
