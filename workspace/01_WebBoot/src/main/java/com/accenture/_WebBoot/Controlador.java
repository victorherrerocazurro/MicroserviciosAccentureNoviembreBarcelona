package com.accenture._WebBoot;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {

	@Autowired
	private Servicio servicio;
	
	//Consumes comprueba el valor de la cabecera content_type
	//Produces comprueba el valor de la cabecera accept
	//@RequestParam -> ?nombre=Victor
	@RequestMapping(path="/metodo/{id}", 
				method=RequestMethod.POST, 
				consumes=MediaType.APPLICATION_JSON_VALUE,
				produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonajeSimpson> metodo( @PathVariable Long id, 
				@RequestParam(required=false) String nombre,
				@RequestBody PersonajeSimpson personaje ) throws URISyntaxException{
		
		System.out.println("En el controlador: personaje = " 
										+ personaje + ", id = " + id);
		//Invoque la capa de negocio
		servicio.metodoDeNegocio();
		
		//Preparando la respuesta
		HttpHeaders headers = new HttpHeaders();
		
		headers.setLocation(new URI("http://localhost:8080/metodo/" + id));
		
		return new ResponseEntity<PersonajeSimpson>(
								personaje, headers , HttpStatus.CREATED) ;
	}
	
}
