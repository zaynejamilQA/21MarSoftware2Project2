package com.qa.mma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.mma.domain.Mma;
import com.qa.mma.repo.MmaRepo;

@Service
public class MmaServiceDB implements MmaService {

	private MmaRepo repo;

	public MmaServiceDB(MmaRepo repo) {
		this.repo = repo;
	}

	@Override
	public Mma create(Mma m) {
		return this.repo.save(m);
	}

	@Override
	public List<Mma> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Mma getById(Long id) {
		Optional<Mma> optionalFighter = this.repo.findById(id);
		return optionalFighter.get();
	}

	@Override
	public Mma getFighterByName(String name) {
		return this.repo.findByName(name);
	}

	@Override
	public Mma updateFighter(Long id, Mma newMma) {
		Mma fighter = this.repo.findById(id).orElseThrow();
		fighter.setAge(newMma.getAge());
		fighter.setName(newMma.getName());
		fighter.setWins(newMma.getWins());
		fighter.setLosses(newMma.getLosses());
		fighter.setDraws(newMma.getDraws());
		fighter.setNo_contests(newMma.getNo_contests());
		return this.repo.save(fighter);
	}

	@Override
	public boolean remove(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
