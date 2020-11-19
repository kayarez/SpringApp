package com.kerez.JavaSpringProject.repository;

import com.kerez.JavaSpringProject.model.FilmModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<FilmModel, Long> {
    @Query(value="select sc.id,sc.name, sc.rating, sc.description,sc.image, sc.duration, sc.producer_id from film sc left join users_and_films on sc.id=users_and_films.id where users_and_films.film_id is null",nativeQuery = true)
    List<FilmModel> getFilms();

}
