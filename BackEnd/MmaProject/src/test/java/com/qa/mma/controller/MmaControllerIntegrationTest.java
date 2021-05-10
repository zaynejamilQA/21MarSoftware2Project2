package com.qa.mma.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.mma.domain.Mma;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:schema.sql","classpath:data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class MmaControllerIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception{
		final Mma created = new Mma("Khabib", 29, 0, 0, 0, 0);
		final String createdJSON = this.mapper.writeValueAsString(created);
		RequestBuilder mockRequest = post("/create").contentType(MediaType.APPLICATION_JSON).content(createdJSON);
		final Mma saved = new Mma(3L, "Khabib", 29, 0, 0, 0, 0);
		final String savedJSON = this.mapper.writeValueAsString(saved);
		ResultMatcher matchStatus = status().isCreated();
		ResultMatcher matchBody = content().json(savedJSON);
		this.mockMVC.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}
	
	@Test
	void testGetAll() throws Exception {
		final List<Mma> expected = new ArrayList<>();
		expected.add(new Mma(1L, "Conor McGregor", 32, 23, 5, 0, 0));
		final String expectedJSON = this.mapper.writeValueAsString(expected);
		RequestBuilder mockRequest = get("/getAll");
		ResultMatcher matchStatus = status().isOk();
		ResultMatcher matchBody = content().json(expectedJSON);
		this.mockMVC.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}
	
	@Test
	void testGetOne() throws Exception{
		final Mma expected = new Mma(1L, "Conor McGregor", 32, 23, 5, 0, 0);
		final String expectedJSON = this.mapper.writeValueAsString(expected);
		RequestBuilder mockRequest = get("/getOne/1");
		ResultMatcher matchStatus = status().isOk();
		ResultMatcher matchBody = content().json(expectedJSON);
		this.mockMVC.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);
	}
	
	@Test
	void testGetByName() throws Exception{
		final Mma expected = new Mma(1L, "Conor McGregor", 32, 23, 5, 0, 0);
		final String space = " ";
		final String expectedJSON = this.mapper.writeValueAsString(expected);
		RequestBuilder mockRequest = get("/getByName/Conor"+space+"McGregor");
		ResultMatcher matchStatus = status().isOk();
		ResultMatcher matchBody = content().json(expectedJSON);
		this.mockMVC.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);	
	}
	
	@Test
	void testRemove() throws Exception{
		//final boolean expected = false;
		//final String expectedJSON = this.mapper.writeValueAsString(expected);
		RequestBuilder mockRequest = delete("/remove/1").contentType(MediaType.APPLICATION_JSON);
		ResultMatcher matchStatus = status().isNoContent();
		//ResultMatcher matchBody = content().json(expectedJSON, false);
		this.mockMVC.perform(mockRequest).andExpect(matchStatus);
		//.andExpect(matchBody)
	}
	
	@Test
	void testUpdate() throws Exception{
		final Mma expected = new Mma(1L, "Conor", 32, 23, 5, 0, 0);
		final String expectedJSON = this.mapper.writeValueAsString(expected);
		RequestBuilder mockRequest = put("/update/1").contentType(MediaType.APPLICATION_JSON).content(expectedJSON);
		ResultMatcher matchStatus = status().isOk();
		ResultMatcher matchBody = content().json(expectedJSON);
		this.mockMVC.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);	
	}
}
