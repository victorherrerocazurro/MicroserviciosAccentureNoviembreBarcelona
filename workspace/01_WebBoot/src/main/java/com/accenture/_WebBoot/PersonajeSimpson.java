package com.accenture._WebBoot;

public class PersonajeSimpson {
	private Long id;
	private String nombre;
	
	public PersonajeSimpson(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public PersonajeSimpson() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "PersonajeSimpson [id=" + id + ", nombre=" + nombre + "]";
	}
}
