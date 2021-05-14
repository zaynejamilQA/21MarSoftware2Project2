package com.qa.mma.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int age;
	private int wins;
	private int losses;
	private int draws;
	private int no_contests;

	public Mma() {
	}

	public Mma(String name, int age, int wins, int losses, int draws, int no_contests) {
		super();
		this.name = name;
		this.age = age;
		this.wins = wins;
		this.losses = losses;
		this.draws = draws;
		this.no_contests = no_contests;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getDraws() {
		return draws;
	}

	public void setDraws(int draws) {
		this.draws = draws;
	}

	public int getNo_contests() {
		return no_contests;
	}

	public void setNo_contests(int no_contests) {
		this.no_contests = no_contests;
	}

}