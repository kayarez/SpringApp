package com.kerez.JavaSpringProject.service.impl;

import com.kerez.JavaSpringProject.model.Film;
import com.kerez.JavaSpringProject.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    FilmRepository filmRepository;

    public List<Film> GetAllFilms() {
        return (List<Film>) filmRepository.findAll();
    }
    public Film saveFilm(Film film){
        return filmRepository.save(film);
    }
    public void updateFilm(Film film){ filmRepository.deleteById(film.id);
    Film film1=new Film();
    film1.name=film.name;
    film1.description=film.description;
    filmRepository.save(film1);
    }
    public void deleteById(int id){ filmRepository.deleteById(id);}

}
