package com.texoit.raspberryawards.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.texoit.raspberryawards.entity.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

}
