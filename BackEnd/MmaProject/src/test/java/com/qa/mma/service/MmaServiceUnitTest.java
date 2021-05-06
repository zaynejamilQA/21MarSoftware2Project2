package com.qa.mma.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.mma.domain.Mma;
import com.qa.mma.repo.MmaRepo;

@SpringBootTest
public class MmaServiceUnitTest {

	@Autowired
	private MmaService service;
	
	@MockBean
	private MmaRepo repo;
	
	@Test
	void testCreate() {
		//GIVEN
		Mma conor = new Mma("Conor McGregor", 32, 23, 5, 0, 0);
		Mma savedConor = new Mma(1L, "Conor McGregor", 32, 23, 5, 0, 0);
		//WHEN
		Mockito.when(this.repo.save(conor)).thenReturn(savedConor);
		//THEN
		assertThat(this.service.create(conor)).isEqualTo(savedConor);
		//CHECKS
		Mockito.verify(this.repo, Mockito.times(1)).save(conor);
	}
}
