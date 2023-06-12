package com.examples.springboot.error.app.errors;

public class UsuarioNoEncontradoException extends RuntimeException {

	
	public UsuarioNoEncontradoException(String id) {
		super("Usuario con Id:".concat(id).concat("No existe en el sistema"));

	}

	private static final long serialVersionUID = 1L;
	

}
