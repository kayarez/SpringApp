package com.kerez.JavaSpringProject.repository;


import com.kerez.JavaSpringProject.model.Producer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends CrudRepository<Producer, Integer> {
}
