package com.accenture.receptor;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.accenture.emisor.Mensaje;

@Service
public class ReceptorDeMensajes {

	@JmsListener(destination="mensajes")
	public void procesarMensaje(Mensaje mensaje) {
		System.out.println("Procesando el mensaje: " + mensaje);
	}
	
}
