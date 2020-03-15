package com.quixada.marsweather.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quixada.marsweather.api.entities.Sol;
import com.quixada.marsweather.api.repositories.SolRepository;
import com.quixada.marsweather.api.services.SolService;

@Service
public class SolServiceImpl implements SolService {

	private static final Logger log = LoggerFactory.getLogger(SolServiceImpl.class);

	@Autowired
	private SolRepository solRepository;

	@Override
	public Optional<Sol> findById(Long id) {
		log.info("Finding by ID {}", id);
		return Optional.ofNullable(solRepository.findById(id));
	}

	@Override
	public Sol persist(Sol Sol) {
		log.info("Persisting Sol: {}", Sol);
		return this.solRepository.save(Sol);
	}
	
	@Override
	public Page<Sol> findAll(Pageable pageable){
		log.info("Returns all Sols: {}");
		return this.solRepository.findAll(pageable);
	}

}
