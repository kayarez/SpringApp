package com.kerez.JavaSpringProject.controller;

import com.kerez.JavaSpringProject.OAP.Loggable;
import com.kerez.JavaSpringProject.model.Producer;
import com.kerez.JavaSpringProject.service.FilmProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProducerController {
    @Autowired
    FilmProducerService filmproducerService;

    @Loggable
    @GetMapping("/producers")
    public List<Producer> getProducer(){
        return filmproducerService.getProducer();
    }

    @Loggable
    @PostMapping("/producers")
    public Producer saveProducer(@RequestBody Producer model){
        return filmproducerService.save(model);
    }
}
