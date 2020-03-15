package com.quixada.marsweather.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.quixada.marsweather.api.entities.Sol;

public interface SolService {

	/**
	 * Returns a Sol based on a ID.
	 * 
	 * @param id
	 * @return Optional<Sol>
	 */
	Optional<Sol> findById(Long id);
	
	/**
	 * Create a new SOL in the Database.
	 * 
	 * @param Sol
	 * @return sol
	 */
	Sol persist(Sol sol);
	
	Page<Sol> findAll(Pageable pageable);
	
}
