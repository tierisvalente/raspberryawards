package com.texoit.raspberryawards.controller;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerControllerTests {

	private MockMvc mockMvc;

	@Autowired
	protected WebApplicationContext applicationContext;

	@Autowired
	private ProducerController producerController;

	@Before
	public void setup() throws Exception {
		this.mockMvc = standaloneSetup(producerController).build();
	}

	@Test
	public void testIntervalMax() throws Exception {
		mockMvc.perform(get("/interval").contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.max.*", hasItem(notNullValue())));
	}
	
	@Test
	public void testIntervalMin() throws Exception {
		mockMvc.perform(get("/interval").contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.min.*", hasItem(notNullValue())));
	}
}
