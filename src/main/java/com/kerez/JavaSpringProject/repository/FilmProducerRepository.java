package com.kerez.JavaSpringProject.repository;


import com.kerez.JavaSpringProject.model.FilmProducerModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmProducerRepository extends CrudRepository<FilmProducerModel, Long> {
    @Query(value="select sc.id,sc.name from film_producer sc left join films on sc.id=films.id where films.film_id is null",nativeQuery = true)
    FilmProducerModel getProducer();
}
