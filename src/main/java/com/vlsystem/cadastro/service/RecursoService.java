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
	//percorre a lista e busca  todos os recursos
	public List<RecursoDto> listarTodos() {
		List<RecursoEntity> recursos = recursoRepository.findAll();
		return recursos.stream().map(RecursoDto::new).toList();

	}
	//insere os recursos a lista
	public void addRecursos(RecursoDto recurso) {
		RecursoEntity recursoEntity = new RecursoEntity(recurso);
		recursoRepository.save(recursoEntity);

	}
	//faz o update (atualização)dos recursos
	public RecursoDto alterar(RecursoDto recurso) {
		RecursoEntity recursoEntity = new RecursoEntity(recurso);
		return new RecursoDto(recursoRepository.save(recursoEntity));
	}
	//deletar por (id)
	public void excluir(Long id) {
		RecursoEntity recurso = recursoRepository.findById(id).get();
		recursoRepository.delete(recurso);

	}

	// faz a busca do recurso por (id)
	/**public RecursoDto buscarPorId(Long id) {
		return new RecursoDto(recursoRepository.findById(id).get());

	}*/
}