package com.texoit.raspberryawards.setup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.texoit.raspberryawards.entity.Movie;
import com.texoit.raspberryawards.entity.Producer;
import com.texoit.raspberryawards.service.MovieService;
import com.texoit.raspberryawards.service.ProducerService;

@Component
public class LoadData {

	@Value("${file.path}")
	private String filePath;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private ProducerService producerService;
	
	private List<String[]> readData() {
		List<String[]> data = new ArrayList<>();
		
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + filePath))){
			String line = "";
			String csvSeparator = ";";
			boolean isFirstLine = true;
			while((line = bufferedReader.readLine()) != null) {
				if(isFirstLine) {
					isFirstLine = false;
					continue;
				}
				
				data.add(line.split(csvSeparator));
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		return data;
	}
	
	@PostConstruct
	public void saveData() {
		List<String[]> data = readData();
		
		data.stream().forEach(str -> {
			Producer producer = producerService.findByName(str[3]);
			Movie movie = new Movie();
			
			if(producer == null) {
				producer = new Producer();
				producer.setName(str[3]);
				producerService.save(producer);
			}
			
			movie.setName(str[1]);
			movie.setStudio(str[2]);
			movie.setYear(Integer.parseInt(str[0]));
			
			if(str.length == 5) {
				movie.setWinner(str[4] != "" && str[4] != null);
			} else {
				movie.setWinner(false);
			}
			
			movie.setProducer(producer);
			producer.addMovie(movie);
			
			movieService.save(movie);
		});
	}
}
