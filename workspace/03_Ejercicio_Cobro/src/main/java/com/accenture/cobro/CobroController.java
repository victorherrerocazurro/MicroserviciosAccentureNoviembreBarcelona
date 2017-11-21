package com.accenture.cobro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CobroController {

	//No es servicio REST
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> realizarCobro(@RequestBody InformacionDelCobro informacionDelCobro){
		return null;
	}
	
}
