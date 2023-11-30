package com.bookmymovie.dao;

import com.bookmymovie.entity.MovieHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieHallRepository extends JpaRepository<MovieHall,Long> {
}
