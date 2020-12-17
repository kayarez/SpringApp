package com.kerez.JavaSpringProject.Repository;

import com.kerez.JavaSpringProject.repository.FilmProducerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FilmProducerRepositoryTests {
    @Autowired
    private FilmProducerRepository filmproducerRepository;

    @Test
    public void getProducer() {
        Assert.assertNotNull(filmproducerRepository.getProducer());
    }
}

