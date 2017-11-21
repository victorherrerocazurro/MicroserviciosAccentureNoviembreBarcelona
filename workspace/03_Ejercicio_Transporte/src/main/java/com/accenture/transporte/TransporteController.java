package com.accenture.transporte;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EntregaPedido")
public class TransporteController {

	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> tramitarEntregaPedido(
						@RequestBody EntregaPedido entregaPedido){
		//TODO Añadir el Location a la cabecera de respuesta para cumplir con REST
		return null;
	}
	
}
