package com.accenture._WebBoot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracion {

	//<bean id="basicoServicio" class="com.accenture._WebBoot.BasicoServicio"/>
	@Bean
	public Servicio basicoServicio(){
		return new BasicoServicio();
	}
	
}
