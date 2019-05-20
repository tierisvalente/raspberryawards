package com.texoit.raspberryawards.service;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.texoit.raspberryawards.dto.MinMaxDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerServiceTests {

	@Autowired
	private ProducerService producerService;
	
	@Test
	public void testfindAwardsInterval() {
		MinMaxDTO dto = producerService.findAwardsInterval();
		
		assertThat(dto, notNullValue());
	}
}
