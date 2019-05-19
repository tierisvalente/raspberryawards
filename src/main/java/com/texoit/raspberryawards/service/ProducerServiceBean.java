package com.texoit.raspberryawards.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texoit.raspberryawards.dto.MinMaxDTO;
import com.texoit.raspberryawards.dto.ProducerIntervalDTO;
import com.texoit.raspberryawards.entity.Movie;
import com.texoit.raspberryawards.entity.Producer;
import com.texoit.raspberryawards.repository.ProducerRepository;

@Service
public class ProducerServiceBean implements ProducerService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ProducerRepository producerRepository;

	@Override
	public void save(Producer producer) {
		producerRepository.save(producer);
	}

	@Override
	public void delete(Producer producer) {
		producerRepository.delete(producer);
	}

	@Override
	public Producer findByName(String name) {
		return producerRepository.findByName(name);
	}

	@Override
	public List<Producer> findAll() {
		return producerRepository.findAll();
	}

	@Override
	public Optional<Producer> findById(Long id) {
		return producerRepository.findById(id);
	}

	@Override
	public MinMaxDTO findAwardsInterval() {
		List<Producer> producers = producerRepository.findAllWithMoreThanTwoWins();
		List<ProducerIntervalDTO> intervals = new ArrayList<>();
		MinMaxDTO minMaxDTO = new MinMaxDTO();
		
		producers.parallelStream().forEach(producer -> intervals.addAll(convertProducerToIntervalDTO(producer)));
		
		minMaxDTO.setMin(intervals.stream().min(ProducerIntervalDTO::compareTo).orElse(null));
		minMaxDTO.setMax(intervals.stream().max(ProducerIntervalDTO::compareTo).orElse(null));

		return minMaxDTO;
	}

	private List<ProducerIntervalDTO> convertProducerToIntervalDTO(Producer producer) {
		List<ProducerIntervalDTO> dtos = new ArrayList<>();
		ProducerIntervalDTO dto = null;
	
		for(Movie movie : producer.getMovies()) {
			if(dto == null) {
				dto = new ProducerIntervalDTO();
				dto.setProducer(producer.getName());
				dto.setPreviousWin(movie.getYear());
			}else {
				if(dto.getPreviousWin() > movie.getYear()) {
					dto.setFollowingWin(dto.getPreviousWin());
					dto.setPreviousWin(movie.getYear());
				} else {
					dto.setFollowingWin(movie.getYear());
				}
				
				dto.setInterval(dto.getFollowingWin() - dto.getPreviousWin());
				
				dtos.add(dto);
				dto = null;
			}
		}
		
		return dtos;
	}
}
