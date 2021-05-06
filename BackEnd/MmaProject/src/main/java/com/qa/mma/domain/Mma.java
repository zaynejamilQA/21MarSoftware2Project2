package com.qa.mma.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Mma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Name may not be null")
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

	public Mma(Long id, @NotNull(message = "Name may not be null") String name, int age, int wins, int losses,
			int draws, int no_contests) {
		super();
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + draws;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + losses;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + no_contests;
		result = prime * result + wins;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mma other = (Mma) obj;
		if (age != other.age)
			return false;
		if (draws != other.draws)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (losses != other.losses)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (no_contests != other.no_contests)
			return false;
		if (wins != other.wins)
			return false;
		return true;
	}

}