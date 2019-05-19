package com.texoit.raspberryawards.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.texoit.raspberryawards.entity.Producer;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {

	Producer findByName(String name);
	
	@Query(value = "SELECT p FROM Producer p "
			+ "INNER JOIN Movie m ON m.producer.id = p.id "
			+ "WHERE m.winner = 1 AND "
			+ "(SELECT COUNT(id) FROM Movie WHERE producer.id = p.id AND winner = 1) > 1 " 
			+ "GROUP BY p.id, p.name")
	List<Producer> findAllWithMoreThanTwoWins();
}
