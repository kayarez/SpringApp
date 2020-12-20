package com.kerez.JavaSpringProject.service;

import com.kerez.JavaSpringProject.model.Film;
import com.kerez.JavaSpringProject.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService extends AbstractService {
    @Autowired
    FilmRepository repository;

    public FilmService(FilmRepository repository) {
        super(repository);
    }

    public List<Film> getFilms() {
        return (List) repository.findAll();
    }

    public Film save(Film film){
        return this.repository.save(film);
    }
}
