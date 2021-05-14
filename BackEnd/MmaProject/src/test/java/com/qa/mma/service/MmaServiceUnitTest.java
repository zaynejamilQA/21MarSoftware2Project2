package com.qa.mma.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		// GIVEN
		final Mma input = new Mma("Conor McGregor", 32, 23, 5, 0, 0);
		final Mma expected = new Mma(1L, "Conor McGregor", 32, 23, 5, 0, 0);
		// WHEN
		Mockito.when(this.repo.save(input)).thenReturn(expected);
		// THEN
		assertThat(this.service.create(input)).isEqualTo(expected);
		// CHECKS
		Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}

	@Test
	void testGetAll() {
		final List<Mma> expected = new ArrayList<>();
		expected.add(new Mma(1L, "Conor McGregor", 32, 23, 5, 0, 0));
		Mockito.when(this.repo.findAll()).thenReturn(expected);
		assertThat(this.service.getAll()).isEqualTo(expected);
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	void testGetById() {
		final long ID = 1L;
		final Optional<Mma> Optionalexpected = Optional.of(new Mma(1L, "Conor McGregor", 32, 23, 5, 0, 0));
		final Mma expected = new Mma(1L, "Conor McGregor", 32, 23, 5, 0, 0);
		Mockito.when(this.repo.findById(ID)).thenReturn(Optionalexpected);
		assertThat(this.service.getById(ID)).isEqualTo(expected);
		Mockito.verify(this.repo, Mockito.times(1)).findById(ID);
	}

	@Test
	void testGetByName() {
		final String NAME = "Conor McGregor";
		final Mma expected = new Mma(1L, "Conor McGregor", 32, 23, 5, 0, 0);
		Mockito.when(this.repo.findByName(NAME)).thenReturn(expected);
		assertThat(this.service.getFighterByName(NAME)).isEqualTo(expected);
		Mockito.verify(this.repo, Mockito.times(1)).findByName(NAME);
	}

	@Test
	void testRemove() {
		final long ID = 1L;
		Mockito.when(this.repo.existsById(ID)).thenReturn(false);
		assertThat(this.service.remove(ID)).isEqualTo(true);
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(ID);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(ID);
	}

	@Test
	void testUpdateFighter() {
		final long ID = 1L;
		final Mma updated = new Mma(1L, "'The Notourious' Conor McGregor", 33, 26, 6, 1, 1);
		final Optional<Mma> Optionalexpected = Optional.of(new Mma(1L, "Conor McGregor", 32, 23, 5, 0, 0));
		final Mma expected = new Mma(1L, "Conor McGregor", 32, 23, 5, 0, 0);
		Mockito.when(this.repo.findById(ID)).thenReturn(Optionalexpected);
		Mockito.when(this.repo.save(updated)).thenReturn(updated);
		assertThat(this.service.updateFighter(ID, updated)).isEqualTo(updated);
		Mockito.verify(this.repo, Mockito.times(1)).findById(ID);
		Mockito.verify(this.repo, Mockito.times(1)).save(updated);
	}
}
