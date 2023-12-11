package com.vlsystem.cadastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlsystem.cadastro.dto.PermissaoPerfilRecursoDto;
import com.vlsystem.cadastro.entity.PermissaoPerfilRecursoEntity;
import com.vlsystem.cadastro.repository.PermissaoPerfilRecursoRepository;

@Service
public class PermissaoPerfilRecursoService {
	
	@Autowired
	private PermissaoPerfilRecursoRepository permissaoPerfilRecursoRepository;
	
	public List<PermissaoPerfilRecursoDto> listarTodos(){
		List<PermissaoPerfilRecursoEntity> permissaoPerfilRecusos = permissaoPerfilRecursoRepository.findAll();
		return permissaoPerfilRecusos.stream().map(PermissaoPerfilRecursoDto::new).toList();
	}
	
	public void inserir(PermissaoPerfilRecursoDto permissaoPerfilRecurso) {
		PermissaoPerfilRecursoEntity permissaoPerfilRecursoEntity = new PermissaoPerfilRecursoEntity(permissaoPerfilRecurso);
		permissaoPerfilRecursoRepository.save(permissaoPerfilRecursoEntity);
	}
	
	public PermissaoPerfilRecursoDto alterar(PermissaoPerfilRecursoDto permissaoPerfilRecurso) {
		PermissaoPerfilRecursoEntity permissaoPerfilRecursoEntity = new PermissaoPerfilRecursoEntity(permissaoPerfilRecurso);
		return new PermissaoPerfilRecursoDto(permissaoPerfilRecursoRepository.save(permissaoPerfilRecursoEntity));
	}
	
	public void excluir(Long id) {
		PermissaoPerfilRecursoEntity permissaoPerfilRecurso = permissaoPerfilRecursoRepository.findById(id).get();
		permissaoPerfilRecursoRepository.delete(permissaoPerfilRecurso);
	}
	
	public PermissaoPerfilRecursoDto buscarPorId(Long id) {
		return new PermissaoPerfilRecursoDto(permissaoPerfilRecursoRepository.findById(id).get());
	}

}
