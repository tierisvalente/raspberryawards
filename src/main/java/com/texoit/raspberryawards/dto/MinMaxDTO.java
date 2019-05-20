package com.texoit.raspberryawards.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import lombok.Data;

@Data
public class MinMaxDTO {

	private List<ProducerIntervalDTO> min;
	
	private List<ProducerIntervalDTO> max;
	
	public void addMin(ProducerIntervalDTO dto) {
		if(CollectionUtils.isEmpty(min)) {
			min = new ArrayList<>();
		}
		
		min.add(dto);
	}
	
	public void addMax(ProducerIntervalDTO dto) {
		if(CollectionUtils.isEmpty(max)) {
			max = new ArrayList<>();
		}
		
		max.add(dto);
	}
}
