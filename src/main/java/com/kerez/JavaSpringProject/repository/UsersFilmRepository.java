package com.kerez.JavaSpringProject.repository;

import com.kerez.JavaSpringProject.model.UsersAndFilmsModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersFilmRepository extends CrudRepository<UsersAndFilmsModel, Long> {
    @Query(value = "select us.id,us.user_id,us.film_id,us.reviews,us.duration from users_and_films us inner join film sc on us.film_id=sc.id where us.user_id = ?1", nativeQuery = true)
    List<UsersAndFilmsModel> getAllUsersFilms(int id);
}
