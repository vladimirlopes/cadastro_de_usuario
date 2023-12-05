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

import com.vlsystem.cadastro.dto.RecursoDto;
import com.vlsystem.cadastro.service.RecursoService;

@RestController
@RequestMapping(value="/recurso")
@CrossOrigin
public class RecursoController {
	
	@Autowired
	private RecursoService recursoService;
	
	@GetMapping
	public List<RecursoDto>listarTodos(){
		return recursoService.listarTodos();
	}
	@PostMapping
	public void addRecusos(@RequestBody RecursoDto recurso) {
		recursoService.addRecursos(recurso);
		
	}
	@PutMapping
	public RecursoDto alterar(RecursoDto recusso) {
	return recursoService.alterar(recusso);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		recursoService.excluir(id);
		return ResponseEntity.ok().build();
		
		
	}
}
