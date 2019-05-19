package com.texoit.raspberryawards.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	
	@Id
	@GeneratedValue
	@Column(name = "movie_id")
	private Long id;
	
	@Column(name = "movie_name")
	private String name;
	
	@Column(name = "movie_year")
	private Integer year;
	
	@Column(name = "movie_studio")
	private String studio;
	
	@Column(name = "movie_winner")
	private Boolean winner;
	
	@ManyToOne()
	@JoinColumn(name = "producer_id")
	private Producer producer;
}
