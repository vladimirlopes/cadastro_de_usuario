package com.example.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro.dto.UsuarioDto;
import com.example.cadastro.service.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	@GetMapping
	public List<UsuarioDto>listarTodos(){
		return usuarioService.listarTodos();
	}
	@PostMapping
	public void addUsuario(@RequestBody UsuarioDto usuario) {
		usuarioService.addUsuario(usuario);
		
	}
	@PutMapping
	public UsuarioDto alterar(@RequestBody UsuarioDto usuario) {
		return usuarioService.alterar(usuario);
		
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		usuarioService.excluir(id);
		return ResponseEntity.ok().build();
		
		
	}
}
