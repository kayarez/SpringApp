package com.kerez.JavaSpringProject.Repository;

import com.kerez.JavaSpringProject.repository.ProducerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProducerRepositoryTests {
    @Autowired
    private ProducerRepository filmproducerRepository;

    @Test
    public void getProducer() {
        Assert.assertNotNull(filmproducerRepository.getProducer());
    }
}

