package com.accenture.stock;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/Producto")
public class StockController {

	//Este metodo es REST
	@RequestMapping(method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> consultaPorTipoDeProductoYCantidad(
			@RequestParam String tipo, @RequestParam int cantidad
			){
		return null;
	}
	
	//Este metodo no es REST, ya que DecrementoProducto no es un Recurso
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizarElStockdeUnProducto(
			@RequestBody DecrementoProducto decerentoProducto){
		return null;
	}
	
}
