package com.kerez.JavaSpringProject.service.impl;

import com.kerez.JavaSpringProject.model.Producer;
import com.kerez.JavaSpringProject.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService {
    @Autowired
    ProducerRepository producerRepository;

    public List<Producer> getAllProducers(){
        return (List<Producer>)producerRepository.findAll();
    }
    public Producer save(Producer producer){
        return producerRepository.save(producer);
    }
}
