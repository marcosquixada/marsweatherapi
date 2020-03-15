package com.quixada.marsweather.api.controllers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.quixada.marsweather.api.entities.Sol;
import com.quixada.marsweather.api.services.SolService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class SolControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private SolService SolService;

	private static final String FIND_SOL_ID_URL = "/api/sols/id/";
	private static final Long ID = Long.valueOf(1);
	private static final float MX = Float.valueOf("2.0");
	private static final float MN = Float.valueOf("1.0");
	private static final float AV = Float.valueOf("1.5");

	@Test
	public void testFindSolByInvalidId() throws Exception {
		BDDMockito.given(this.SolService.findById(Mockito.anyString())).willReturn(Optional.empty());

		mvc.perform(MockMvcRequestBuilders.get(FIND_SOL_ID_URL + ID).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.errors").value("Sol not found for ID " + ID));
	}

	@Test
	public void testFindSolByValidId() throws Exception {
		BDDMockito.given(this.SolService.findById(Mockito.anyString()))
				.willReturn(Optional.of(this.getSolData()));

		mvc.perform(MockMvcRequestBuilders.get(FIND_SOL_ID_URL + ID)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.data.id").value(ID))
				.andExpect(jsonPath("$.data.mx", equalTo(MX)))
				.andExpect(jsonPath("$.data.mn", equalTo(MN)))
				.andExpect(jsonPath("$.data.av", equalTo(AV)))
				.andExpect(jsonPath("$.errors").isEmpty());
	}

	private Sol getSolData() {
		Sol Sol = new Sol();
		Sol.setId(ID);
		Sol.setMx(MX);
		Sol.setMn(MN);
		Sol.setAv(AV);
		return Sol;
	}

}
