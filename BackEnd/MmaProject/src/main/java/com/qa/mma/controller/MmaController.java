package com.qa.mma.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.mma.domain.Mma;
import com.qa.mma.service.MmaService;

@RestController
public class MmaController {

	private MmaService service;

	public MmaController(MmaService service) {
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Mma> createFighter(@RequestBody Mma mma) {
		return new ResponseEntity<Mma>(this.service.create(mma), HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Mma>> getMma() {
		return ResponseEntity.ok(this.service.getAll());
	}

	@GetMapping("/getOne/{id}")
	public ResponseEntity<Mma> getFighterById(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.getById(id));
	}

	@GetMapping("/getByName")
	public ResponseEntity<Mma> getFighterByName(@PathParam("name")  String name) {
		return ResponseEntity.ok(this.service.getFighterByName(name));
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Boolean> removeFighter(@PathVariable Long id) {
		return this.service.remove(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT):
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Mma> updateFighter(@PathVariable Long id, @RequestBody Mma mma){
		return new ResponseEntity<Mma>(this.service.updateFighter(id, mma), HttpStatus.OK);
	}

}