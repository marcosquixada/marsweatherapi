package com.quixada.marsweather.api;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.quixada.marsweather.api.entities.Sol;
import com.quixada.marsweather.api.services.SolService;

@SpringBootApplication
@EnableCaching
public class MarsWeatherApplication {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private SolService solService;
	
	@Bean public RestTemplate restTemplate(){ return new RestTemplate(); }


	public static void main(String[] args) {
		SpringApplication.run(MarsWeatherApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run() throws Exception {
		return args -> {
			ResponseEntity<String> response =
					  restTemplate.getForEntity(
					  "https://api.nasa.gov/insight_weather/?api_key=DEMO_KEY&feedtype=json&ver=1.0",
					  String.class);
			String sols = response.getBody();
			
			JSONObject object = new JSONObject(sols);
			JSONArray keys = object.names();

			for (int i = 0; i < keys.length (); ++i) {

			   String key = keys.getString(i); 
			   if(!(object.get(key) instanceof JSONArray)) {
				   JSONObject js = object.getJSONObject(key);
				   //object.get(key)
				   if(key.matches("-?\\d+")) {
					   System.out.println(key + " - " + " AT: " + js.getJSONObject("AT"));
					   Sol sol = new Sol();
					   sol.setId(Long.parseLong(key));
					   sol.setMn(js.getJSONObject("AT").getFloat("mn"));
					   sol.setMx(js.getJSONObject("AT").getFloat("mx"));
					   sol.setAv(js.getJSONObject("AT").getFloat("av"));
					   
					   solService.persist(sol);
				   }
			   }

			}
		};
	}
}
