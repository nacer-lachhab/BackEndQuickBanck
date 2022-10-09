package backEndQuickBank.treadAPI.model;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import backEndQuickBank.treadAPI.util.TreadUtil;



//connexion a l'API d'Historique.
public class Connection {

		public TreadUtil treadApiConnection(String date){
			
			TreadUtil treadValue= new TreadUtil();
			treadValue.setDate(date);
			
			//date dans l API sous forme String exemple: "2020-01-05".
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://currencyscoop.p.rapidapi.com/historical?date="+date))
					.header("X-RapidAPI-Host", "currencyscoop.p.rapidapi.com")
					.header("X-RapidAPI-Key", "e3f3bb4695msh8c8e6a4266e4929p1caa86jsn04ff1793757e")
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			HttpResponse<String> response;
			
			try {
				response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
				String apiResp = response.body();
				
				//ObjectMapper mapper = new ObjectMapper();
				
				JsonNode resultat;
				try {
					
					resultat = new ObjectMapper().readTree(apiResp)
							.get("response") //retourne un JsonNode contenant un Map de Maps
							.get("rates"); //retourne un JsonNode contenant un Map
					
					
					if(!resultat.has("MAD"))
					{
						System.out.println("date incorrect");
						 return null;
					}
					
					else {
						resultat=resultat.get(TreadUtil.unit);//retourne un JsonNode contenant un seul element; value.
						double result = resultat.asDouble();
						
						System.out.println("la valeur a la date: "+ date +"est: "+result);
						
						treadValue.setValue(result);
						
						return treadValue;
					}
				} //fin try
				
				catch (JsonProcessingException e) {
					
					e.printStackTrace();
					return null;
				}//fin catch
			} catch (IOException | InterruptedException e1) {
				// TODO Auto-generated catch block
				System.out.println("probleme avant connexion a l API");
				e1.printStackTrace();
				return null;
			}
						
			
		}//fin TreadApiConnection.
		
}//fin class Connection.

