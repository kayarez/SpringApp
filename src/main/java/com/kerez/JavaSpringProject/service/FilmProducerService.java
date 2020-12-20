package com.kerez.JavaSpringProject.service;

import com.kerez.JavaSpringProject.model.Producer;
import com.kerez.JavaSpringProject.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FilmProducerService extends AbstractService {
    @Autowired
    ProducerRepository repository;

    public FilmProducerService(ProducerRepository repository) {
        super(repository);
    }

    public List<Producer> getProducer() {
        return (List) repository.findAll();
    }

    public Producer save(Producer filmproducer){
        return this.repository.save(filmproducer);
    }
}

