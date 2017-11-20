package com.accenture._ClienteServicioJson;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControladorCliente {
	
	@Autowired
	private RestTemplate restTemplate;
	
	//Consumes comprueba el valor de la cabecera content_type
	//Produces comprueba el valor de la cabecera accept
	//@RequestParam -> ?nombre=Victor
	@RequestMapping(path="/metodoCliente/{id}", 
				method=RequestMethod.POST, 
				consumes=MediaType.APPLICATION_JSON_VALUE,
				produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Personaje> metodo( 
				@PathVariable Long id, 
				@RequestParam(required=false) String nombre,
				@RequestBody Personaje personaje ) throws URISyntaxException{
		
		System.out.println("En el controlador: personaje = " 
										+ personaje + ", id = " + id);
		
		//Sustituimos una invocacion sobre un bean
		//servicio.metododeNegocio();
		//Por la invocacion una peticion HTTP
		//Realizar peticion HTTP
		ResponseEntity<Personaje> postForEntity = restTemplate.postForEntity(
				"http://localhost:8080/metodo/{id}", 
				personaje, Personaje.class, id);
		
		return postForEntity;
	}
	
}
