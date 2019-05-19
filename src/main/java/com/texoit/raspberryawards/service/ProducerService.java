package com.texoit.raspberryawards.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.texoit.raspberryawards.dto.MinMaxDTO;
import com.texoit.raspberryawards.entity.Producer;

public interface ProducerService extends Serializable {

	void save(Producer producer);

	void delete(Producer producer);

	Producer findByName(String name);

	List<Producer> findAll();

	Optional<Producer> findById(Long id);

	MinMaxDTO findAwardsInterval();

}
