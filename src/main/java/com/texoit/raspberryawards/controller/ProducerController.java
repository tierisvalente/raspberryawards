package com.texoit.raspberryawards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.texoit.raspberryawards.dto.MinMaxDTO;
import com.texoit.raspberryawards.entity.Producer;
import com.texoit.raspberryawards.exception.ProducerNotFoundException;
import com.texoit.raspberryawards.service.ProducerService;

@RestController
public class ProducerController {
	
	@Autowired
	private ProducerService producerService;
	
	@GetMapping("producer")
	public List<Producer> findAll() {
		return producerService.findAll();
	}
	
	@GetMapping("producer/{id}")
	public Producer findById(@PathVariable Long id) {
		return producerService.findById(id).orElseThrow(() -> new ProducerNotFoundException(id));
	}
	
	@GetMapping("interval")
	public MinMaxDTO interval() {
		return producerService.findAwardsInterval();
	}
}
