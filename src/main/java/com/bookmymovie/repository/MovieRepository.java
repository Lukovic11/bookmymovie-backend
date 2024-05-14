package com.bookmymovie.repository;

import com.bookmymovie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    Optional<List<Movie>> findByGenre(String genre);

    Optional<Movie> findByTitle(String title);

    Optional<List<Movie>> findByIsPlayingTrue();



}
