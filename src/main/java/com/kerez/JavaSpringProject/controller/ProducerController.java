package com.kerez.JavaSpringProject.controller;

import com.kerez.JavaSpringProject.model.Producer;
import com.kerez.JavaSpringProject.service.impl.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProducerController {
    @Autowired
    ProducerService producerService;

    @GetMapping("producer")
    public List<Producer> getAllProducers(){
        return producerService.getAllProducers();
    }
    @PostMapping("/rest/api/v1/addProducer/")
    public Producer saveProducer(@RequestBody Producer producer){
        return producerService.save(producer);
    }
}
