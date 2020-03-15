package com.quixada.marsweather.api.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.quixada.marsweather.api.entities.Sol;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class SolRepositoryTest {
	
	@Autowired
	private SolRepository SolRepository;
	
	private static final Long ID = 451L;

	@Before
	public void setUp() throws Exception {
		Sol Sol = new Sol();
		Sol.setMx("2");
		Sol.setMn("1");
		Sol.setAv("1.5");
		Sol.setId(1L);
		this.SolRepository.save(Sol);
	}
	
	@After
    public final void tearDown() { 
		this.SolRepository.deleteAll();
	}

	@Test
	public void testFindByID() {
		Sol Sol = this.SolRepository.findById(ID);
		
		assertEquals(ID, Sol.getId());
	}

}
