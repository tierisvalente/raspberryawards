package com.texoit.raspberryawards.dto;

import lombok.Data;

@Data
public class ProducerIntervalDTO implements Comparable<ProducerIntervalDTO> {

	private String producer;
	
	private Integer interval;
	
	private Integer previousWin;
	
	private Integer followingWin;

	@Override
	public int compareTo(ProducerIntervalDTO o) {
		if(interval.compareTo(o.interval) != 0)
			return interval.compareTo(o.interval);
		
		if(followingWin.compareTo(o.followingWin) != 0)
			return followingWin.compareTo(o.followingWin);
		
		return 0;
	}
}
