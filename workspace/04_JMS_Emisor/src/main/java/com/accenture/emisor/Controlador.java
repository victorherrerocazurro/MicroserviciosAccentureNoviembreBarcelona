package com.accenture.emisor;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@RequestMapping(path="/enviar", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void enviarMensaje(@RequestBody Mensaje mensaje) {
		jmsTemplate.convertAndSend(new ActiveMQTopic("mensajes"), mensaje);
	}
	
}
