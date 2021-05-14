package com.qa.mma.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.mma.domain.Mma;

@Repository
public interface MmaRepo extends JpaRepository<Mma, Long>{
	
	Mma findByName(String name);
}
