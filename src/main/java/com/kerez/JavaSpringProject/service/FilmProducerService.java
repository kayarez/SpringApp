package com.kerez.JavaSpringProject.service;

import com.kerez.JavaSpringProject.model.FilmModel;
import com.kerez.JavaSpringProject.model.FilmProducerModel;
import com.kerez.JavaSpringProject.repository.FilmProducerRepository;
import com.kerez.JavaSpringProject.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FilmProducerService extends AbstractService {
    @Autowired
    FilmProducerRepository repository;

    public FilmProducerService(FilmProducerRepository repository) {
        super(repository);
    }

    public List<FilmProducerModel> getProducer() {
        return (List) repository.findAll();
    }

    public FilmProducerModel save(FilmProducerModel filmproducerModel){
        return this.repository.save(filmproducerModel);
    }
}

