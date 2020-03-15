package com.quixada.marsweather.api.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quixada.marsweather.api.dtos.SolDto;
import com.quixada.marsweather.api.entities.Sol;
import com.quixada.marsweather.api.response.Response;
import com.quixada.marsweather.api.services.SolService;

@RestController
@RequestMapping("/api/sols")
@CrossOrigin(origins = "*")
public class SolController {

	private static final Logger log = LoggerFactory.getLogger(SolController.class);

	@Autowired
	private SolService solService;
	
	@Value("${pagination.qtt_per_page}")
	private int qttPerPage;

	public SolController() {
	}

	/**
	 * Returns a SOL with a given ID.
	 * 
	 * @param id
	 * @return ResponseEntity<Response<SolDto>>
	 */
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Response<SolDto>> findById(@PathVariable("id") Long id) {
		log.info("Finding SOL by ID: {}", id);
		Response<SolDto> response = new Response<SolDto>();
		Optional<Sol> sol = solService.findById(id);

		if (!sol.isPresent()) {
			log.info("Sol not found by ID: {}", id);
			response.getErrors().add("Sol not found for ID " + id);
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(this.convertSolDto(sol.get()));
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Retorna a listagem de lançamentos de um funcionário.
	 * 
	 * @param funcionarioId
	 * @return ResponseEntity<Response<LancamentoDto>>
	 */
	@GetMapping(value = "/all")
	public ResponseEntity<Response<Page<SolDto>>> getAll(Pageable pageable){
		log.info("Getting ALL de data from Sols: {}");
		Response<Page<SolDto>> response = new Response<Page<SolDto>>();

		//PageRequest pageRequest = new PageRequest(0, 25, Direction.valueOf(""), "");
		Page<Sol> sols = this.solService.findAll(pageable);
		Page<SolDto> solsDto = sols.map(sol -> this.convertSolDto(sol));

		response.setData(solsDto);
		return ResponseEntity.ok(response);
	}

	/**
	 * Populates one DTO with the data of a sol.
	 * 
	 * @param sol
	 * @return SolDto
	 */
	private SolDto convertSolDto(Sol sol) {
		SolDto solDto = new SolDto();
		solDto.setId(sol.getId());
		solDto.setMx(sol.getMx());
		solDto.setMn(sol.getMn());
		solDto.setAv(sol.getAv());

		return solDto;
	}

	public int getQttPerPage() {
		return qttPerPage;
	}

	public void setQttPerPage(int qttPerPage) {
		this.qttPerPage = qttPerPage;
	}

}
