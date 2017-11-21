package com.accenture.orquestador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrdenDeCompraController {

	private static final String URL_SERVICIO_GESTION_STOK = "http://{host}:{port}/Producto?tipo={tipo}&cantidad={cantidad}";
	private static final String URL_SERVICIO_COBROS = "http://{host}:{port}/cobro";
	
	@Value("{servicio.gestion_stock.url:localhost}")
	private String hostGestionStock;
	
	@Value("{servicio.gestion_stock.port:8280}")
	private String portGestionStock;
	
	@Value("{servicio.cobro.url:localhost}")
	private String hostCobro;
	
	@Value("{servicio.cobro.port:8480}")
	private String portCobro;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping(path="/OrdenDeCompra", 
			method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> alta(@RequestBody OrdenDeCompra ordenDeCompra){
		//Invocar el resto de servicios
		ResponseEntity<Producto> producto = restTemplate.getForEntity(
				URL_SERVICIO_GESTION_STOK , 
				Producto.class, hostGestionStock, portGestionStock, 
				ordenDeCompra.getTipoProducto(), 
				ordenDeCompra.getCantidad());
		
		if(producto != null) {
		
			ResponseEntity<Void> respuesta = restTemplate.postForEntity(URL_SERVICIO_COBROS, 
					ordenDeCompra.getDatosDeCobro(), 
					Void.class, hostCobro, portCobro);
			
			respuesta.getStatusCode();
		
		} else {
			// Respoden 404 por no haber Stock del producto
		}
		return null;
	}
	
}
