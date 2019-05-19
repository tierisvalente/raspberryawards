package com.texoit.raspberryawards.service;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.texoit.raspberryawards.entity.Movie;

public interface MovieService extends Serializable {

	void save(Movie movie);

	void delete(Movie movie);

}
