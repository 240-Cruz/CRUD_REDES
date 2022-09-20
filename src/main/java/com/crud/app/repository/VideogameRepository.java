package com.crud.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.app.entity.Videogame;

@Repository
public interface VideogameRepository extends JpaRepository<Videogame, Long>{

	
}
