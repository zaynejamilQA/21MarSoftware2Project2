package com.qa.mma.service;

import java.util.List;

import com.qa.mma.domain.Mma;

public interface MmaService {
	// CREATE
	Mma create(Mma m);

	// READ
	List<Mma> getAll();
	Mma getById(Long id);
	Mma getFighterByName(String name);

	// UPDATE
	Mma updateFighter(Long id, Mma newMma);

	// DELETE
	boolean remove(Long id);

}