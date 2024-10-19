package com.rpost.jsilva.controllers;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpost.jsilva.services.PageService;

@RestController
public class PageController {

	@Autowired
	private PageService pageService;
	
	@Value("${reqresurl}") //obtenido de application.properties
	private String getUrl;
	
	@PostMapping("/")
	public String method() {
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		                .uri(URI.create(getUrl))
		                .GET()
		                .build();
		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); //obtiene datos a reestructurar 
			return pageService.reshape(response.body()); //reestructura y devuelve lo obtenido
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			return "Error";
		}
	}
	
	
	@GetMapping("/test")
	public String aTest() {
		
		return "Hola";
	}
}
