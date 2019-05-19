package com.texoit.raspberryawards.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texoit.raspberryawards.entity.Movie;
import com.texoit.raspberryawards.repository.MovieRepository;

@Service
public class MovieServiceBean implements MovieService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public void save(Movie movie) {
		movieRepository.save(movie);
	}

	@Override
	public void delete(Movie movie) {
		movieRepository.delete(movie);
	}

}
