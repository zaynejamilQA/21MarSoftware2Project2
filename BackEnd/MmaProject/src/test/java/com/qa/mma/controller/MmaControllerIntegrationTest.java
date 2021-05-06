package com.qa.mma.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
		// create object
		Mma conor = new Mma("Conor McGregor", 32, 23, 5, 0, 0);
		// convert to JSON
		String conorAsJSON = this.mapper.writeValueAsString(conor);
		// build mock request
		RequestBuilder mockRequest = post("/create").contentType(MediaType.APPLICATION_JSON).content(conorAsJSON);
		// create our "saved" fighter
		Mma savedConor = new Mma(2L, "Conor McGregor", 32, 23, 5, 0, 0);
		// convert saved to JSON
		String savedConorAsJSON = this.mapper.writeValueAsString(savedConor);
		// check status is 201
		ResultMatcher matchStatus = status().isCreated();
		// Check the the response body is the correct fighter
		ResultMatcher matchBody = content().json(savedConorAsJSON);
		this.mockMVC.perform(mockRequest).andExpect(matchBody);

	}
}
