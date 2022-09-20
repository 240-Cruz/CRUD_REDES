package com.crud.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.app.entity.Videogame;
import com.crud.app.service.VideogameService;

@RestController
@RequestMapping("/api/videogames")
public class VideogameController {
	
	@Autowired
	private VideogameService videogameService;

	//Create a new videogame
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Videogame videogame){
		return ResponseEntity.status(HttpStatus.CREATED).body(videogameService.save(videogame));
		
	}
	
	//Read an videogame
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long videogameId) {
		Optional<Videogame> oVideogame = videogameService.findById(videogameId);
		
		if(!oVideogame.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
	return ResponseEntity.ok(oVideogame);
	}
	
	//Update a Videogame
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Videogame videogameDetails, @PathVariable (value ="id")Long videogameId){
		Optional<Videogame> videogame = videogameService.findById(videogameId);
		
		if(!videogame.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		//BeanUtils.copyProperties(videogameDetails, videogame.get());
		videogame.get().setName(videogameDetails.getName());
		videogame.get().setGenre(videogameDetails.getGenre());
		videogame.get().setClassification(videogameDetails.getClassification());
		videogame.get().setEnabled(videogameDetails.getEnabled());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(videogameService.save(videogame.get()));
	}
	
	//Delete a Videogame
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long videogameId) {
		
		if (!videogameService.findById(videogameId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		videogameService.deleteById(videogameId);
		return ResponseEntity.ok().build();
	}
	
	//Read all videogames
	@GetMapping
	public List<Videogame> readAll () {
		
		List<Videogame> videogames = StreamSupport
				.stream(videogameService.findAll().spliterator(), false)
				.collect(Collectors.toList());
				
				return videogames;
	}
}
