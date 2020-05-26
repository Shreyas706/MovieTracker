package com.assignment.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.boot.test.mock.mockito.MockBean;

import com.assignment.service.MovieService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MovieControllerTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieControllerTest.class);
	
	@MockBean
	private MovieService movieService;
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void findMovie() throws Exception {
		mockMvc.perform(get("/movie")).andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}

	@Test
	public void findMovieById() throws Exception {
		mockMvc.perform(get("/movie/{id}", 1)).andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}
	@Test
	public void addMovie() throws Exception {
		
		mockMvc.perform(post("/movie").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content("{\"requestBody\":{\"title\": \"3 idiots\", \"category\": \"comedy-drama\",\"rating\": 0.2}}"))
		.andDo(print())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
		;
	}

	
	@Test
	public void updateMovie() throws Exception {
		
		mockMvc.perform(post("/movie/{id}",4).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content("{\"requestBody\":{\"title\": \"3 idiots\", \"category\": \"drama\",\"rating\": 0.2}}"))
		.andDo(print())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
		;
	}
	
	@Test
	public void deleteMovieById() throws Exception {
		mockMvc.perform(delete("/movie/{id}", 7)).andDo(print())
				.andExpect(status().isOk());
	}
	
}
