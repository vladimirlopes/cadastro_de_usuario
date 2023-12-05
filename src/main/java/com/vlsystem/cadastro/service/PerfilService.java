package com.vlsystem.cadastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlsystem.cadastro.dto.PerfilDto;
import com.vlsystem.cadastro.entity.PerfilEntity;
import com.vlsystem.cadastro.repository.PerfilRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;

	public List<PerfilDto> listarTodos() {
		List<PerfilEntity> perfil = perfilRepository.findAll();
		return perfil.stream().map(PerfilDto::new).toList();
	}

	public void addPerfil(PerfilDto perfil) {
		PerfilEntity perfilEntity = new PerfilEntity(perfil);
		perfilRepository.save(perfilEntity);
	}
	public PerfilDto alterar(PerfilDto perfil) {
		PerfilEntity perfilEntity = new PerfilEntity(perfil);
		return new PerfilDto(perfilRepository.save(perfilEntity));
		
	}
	public void excluir(Long id) {
		PerfilEntity perfil = perfilRepository.findById(id).get();
		perfilRepository.delete(perfil);
		
	}
	public PerfilDto buscarPorId(Long id) {
		return new PerfilDto(perfilRepository.findById(id).get());
		
		
	}
}
