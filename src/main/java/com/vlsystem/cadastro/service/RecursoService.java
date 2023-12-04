package com.vlsystem.cadastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlsystem.cadastro.dto.RecursoDto;
import com.vlsystem.cadastro.entity.RecursoEntity;
import com.vlsystem.cadastro.repository.RecursoRepository;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Service
public class RecursoService {
	
	@Autowired
	private RecursoRepository recursoRepository;
	
	public List<RecursoDto> listarTodos() {
		List<RecursoEntity> recursos = recursoRepository.findAll();
		return recursos.stream().map(RecursoDto::new).toList();

	}
	public void addRecursos(RecursoDto recurso) {
		RecursoEntity recursoEntity = new RecursoEntity(recurso);
		recursoRepository.save(recursoEntity);
		
	}
	public RecursoDto alterar(RecursoDto recurso) {
		RecursoEntity recursoEntity = new RecursoEntity(recurso);
		
		return new RecursoDto(recursoRepository.save(recursoEntity));
}
	public void excluir(Long id) {
		RecursoEntity recursos = recursoRepository.findById(id).get();
		recursoRepository.delete(recursos);
		
	}
	// faz a busca do recurso por (id)
		public RecursoDto buscarPorId(Long id) {
			return new RecursoDto(recursoRepository.findById(id).get());

		}
}