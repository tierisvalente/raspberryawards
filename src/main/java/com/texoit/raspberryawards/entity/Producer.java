package com.texoit.raspberryawards.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producer {

	@Id
	@GeneratedValue
	@Column(name = "producer_id")
	private Long id;

	@Column(name = "producer_name")
	private String name;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "producer")
	@JsonIgnore
	private List<Movie> movies;

	public void addMovie(Movie movie) {
		if (CollectionUtils.isEmpty(movies)) {
			movies = new ArrayList<>();
		}
		
		movies.add(movie);
	}
}
