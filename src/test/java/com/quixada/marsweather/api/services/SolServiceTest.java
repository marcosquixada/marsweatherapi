package com.quixada.marsweather.api.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.quixada.marsweather.api.entities.Sol;
import com.quixada.marsweather.api.repositories.SolRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class SolServiceTest {

	@MockBean
	private SolRepository SolRepository;

	@Autowired
	private SolService SolService;

	private static final String ID = "2";

	@Before
	public void setUp() throws Exception {
		BDDMockito.given(this.SolRepository.findById(Mockito.anyString())).willReturn(new Sol());
		BDDMockito.given(this.SolRepository.save(Mockito.any(Sol.class))).willReturn(new Sol());
	}

	@Test
	public void testBuscarSolPorCnpj() {
		Optional<Sol> Sol = this.SolService.findById(ID);

		assertTrue(Sol.isPresent());
	}
	
	@Test
	public void testPersistirSol() {
		Sol Sol = this.SolService.persist(new Sol());

		assertNotNull(Sol);
	}

}
