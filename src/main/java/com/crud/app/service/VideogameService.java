package com.crud.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.crud.app.entity.Videogame;

public interface VideogameService {

	public Iterable<Videogame> findAll();
	
	public Page<Videogame> findAll(Pageable pageable);
	
	public Optional<Videogame> findById(Long id);
	
	public Videogame save(Videogame videogame);
	
	public void deleteById(Long id);
}
