package com.kerez.JavaSpringProject.service;

import com.kerez.JavaSpringProject.model.FilmModel;
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

    public List<FilmModel> getFilms() {
        return (List) repository.findAll();
    }

    public FilmModel save(FilmModel filmModel){
        return this.repository.save(filmModel);
    }
}
