package com.accenture.emisor;

import java.io.Serializable;

/**
 * @author sinensia
 *
 */
public class Mensaje implements Serializable{

	private int id;
	private String texto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", texto=" + texto + "]";
	}
}
