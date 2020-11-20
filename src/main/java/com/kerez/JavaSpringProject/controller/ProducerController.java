package com.kerez.JavaSpringProject.controller;

import com.kerez.JavaSpringProject.OAP.Loggable;
import com.kerez.JavaSpringProject.model.FilmModel;
import com.kerez.JavaSpringProject.model.FilmProducerModel;
import com.kerez.JavaSpringProject.service.FilmProducerService;
import com.kerez.JavaSpringProject.service.FilmService;
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
    public List<FilmProducerModel> getProducer(){
        return filmproducerService.getProducer();
    }

    @Loggable
    @PostMapping("/producers")
    public FilmProducerModel saveProducer(@RequestBody FilmProducerModel model){
        return filmproducerService.save(model);
    }
}
