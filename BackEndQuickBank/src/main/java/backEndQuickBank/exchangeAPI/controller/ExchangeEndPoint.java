package backEndQuickBank.exchangeAPI.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import backEndQuickBank.exchangeAPI.model.ExchangeModel;

@CrossOrigin
@RestController
@RequestMapping(path = "/convertion")
public class ExchangeEndPoint {
	
	@GetMapping
	public ExchangeModel getConnection(
			@RequestParam(name ="us") String unit,
			@RequestParam("ud") String unitDest) throws Exception 
	{
		ExchangeModel model = new ExchangeModel();
		
		model.setSourceUnit(unit.toUpperCase());
		model.setToUnit(unitDest.toUpperCase());
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://exchangerate-api.p.rapidapi.com/rapid/latest/"+unit))
				.header("X-RapidAPI-Host", "exchangerate-api.p.rapidapi.com")
				.header("X-RapidAPI-Key", "e3f3bb4695msh8c8e6a4266e4929p1caa86jsn04ff1793757e")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		//System.out.println(response.body());
		String resApiConnection = response.body();
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode jsonresultat =mapper.readTree(resApiConnection);
		
		jsonresultat=jsonresultat.get("rates");
		
		JsonNode jsonresultat2 = jsonresultat.get(unitDest.toUpperCase());
		
		double taux=jsonresultat2.asDouble();
		System.out.println("le taux est "+ taux);
		
		model.setTaux(taux);
		
		return model;
	}
	
}
