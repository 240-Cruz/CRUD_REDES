package com.crud.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.app.entity.Videogame;
import com.crud.app.repository.VideogameRepository;

@Service
public class VideogameServiceImpl implements VideogameService {
	
	@Autowired
	private VideogameRepository videogameRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Videogame> findAll() {
		return videogameRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Videogame> findAll(Pageable pageable) {
		return videogameRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Videogame> findById(Long id) {
		return videogameRepository.findById(id);
	}

	@Override
	@Transactional
	public Videogame save(Videogame videogame) {
		return videogameRepository.save(videogame);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		videogameRepository.deleteById(id);
		
	}

}
