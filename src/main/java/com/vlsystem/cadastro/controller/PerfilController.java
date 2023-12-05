package com.vlsystem.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlsystem.cadastro.dto.PerfilDto;
import com.vlsystem.cadastro.service.PerfilService;

@RestController
@RequestMapping(value = "/perfil")
@CrossOrigin
public class PerfilController {
	
	@Autowired PerfilService perfilService;
	
	@GetMapping
	public List<PerfilDto>listarTodos(){
		return perfilService.listarTodos();
		
	}
	@PostMapping
	public void addPerfil(@RequestBody PerfilDto perfil) {
		perfilService.addPerfil(perfil);
	}
	@PutMapping
	public PerfilDto alterar(@RequestBody PerfilDto perfil) {
		return perfilService.alterar(perfil);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>excluir(@PathVariable Long id){
		perfilService.excluir(id);
		return ResponseEntity.ok().build();
		
	}
}
