package com.kerez.JavaSpringProject.service;

import com.kerez.JavaSpringProject.model.FilmModel;
import com.kerez.JavaSpringProject.repository.FilmRepository;
import com.kerez.JavaSpringProject.repository.PageableFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FilmService extends AbstractService{
    @Autowired
    FilmRepository repository;
    @Autowired
    PageableFilmRepository pageableFilmRepository;

    public FilmService(FilmRepository repository) {
        super(repository);
    }
    public List<FilmModel> getFilms(){
        return repository.getFilms();
    }
}
