package com.quixada.marsweather.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.quixada.marsweather.api.entities.Sol;

public interface SolRepository extends JpaRepository<Sol, Long> {
	
	@Transactional(readOnly = true)
	Sol findById(String id);
	
	Page<Sol> findAll(Pageable pageable);

}
