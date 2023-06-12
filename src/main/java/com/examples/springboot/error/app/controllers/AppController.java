package com.examples.springboot.error.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.examples.springboot.error.app.domain.Usuario;
import com.examples.springboot.error.app.errors.UsuarioNoEncontradoException;
import com.examples.springboot.error.app.services.UsuarioService;

@Controller
public class AppController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@SuppressWarnings("unused")
	@GetMapping("/index")
	public String index() {
		Integer valor = 100/0;
		//Integer valor = Integer.parseInt("10xaaa");
		return "index";
		
	}
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable Integer id, Model model) {
		/*
		Usuario usuario = usuarioService.obtenerPorId(id);
		if (usuario==null) {
			throw new UsuarioNoEncontradoException(id.toString());
		}*/
		
		Usuario usuario = usuarioService.obtenerPorIdOptional(id).orElseThrow(()-> new UsuarioNoEncontradoException(id.toString()));
		
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo", "Detalle usuario: ".concat(usuario.getNombre()));
		return "ver";
	}

}
