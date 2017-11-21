package com.accenture.orquestador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrdenDeCompraController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(path="/OrdenDeCompra", 
			method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> alta(@RequestBody OrdenDeCompra ordenDeCompra){
		//Invocar el resto de servicios
		
		
		
		
		return null;
	}
	
}
