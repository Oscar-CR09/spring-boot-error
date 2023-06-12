package com.examples.springboot.error.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examples.springboot.error.app.domain.Usuario;

@Service
public class UsuarioServiceImplement implements UsuarioService {

	private List<Usuario> lista;
	
	
	public UsuarioServiceImplement() {
		this.lista = new ArrayList<>();
		this.lista.add(new Usuario(1, "Oscar", "Cervantes"));
		this.lista.add(new Usuario(2, "Carol", "Garcia"));
		this.lista.add(new Usuario(3, "Liz", "Barona"));
		this.lista.add(new Usuario(4, "Carlos", "Hernandez"));
		this.lista.add(new Usuario(5, "Juan", "Mena"));
		this.lista.add(new Usuario(6, "Paco", "Solis"));
		this.lista.add(new Usuario(7, "Vero", "Gomez"));
		
	}

	@Override
	public List<Usuario> listar() {
		
		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario resultado = null;
		for (Usuario u: this.lista) {
			if (u.getId().equals(id)) {
				resultado = u;
				break;
				
			}
			
		}
		
		return resultado;
	}

	@Override
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		Usuario usuario = this.obtenerPorId(id);
		return Optional.ofNullable(usuario);
	}

}
