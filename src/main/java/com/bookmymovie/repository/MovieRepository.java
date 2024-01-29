package com.bookmymovie.repository;

import com.bookmymovie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findByGenre(String genre);

    Movie findByTitle(String title);



}
