package com.vlsystem.cadastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlsystem.cadastro.dto.PerfilUsuarioDto;
import com.vlsystem.cadastro.entity.PerfilUsuarioEntity;
import com.vlsystem.cadastro.repository.PerfilUsuarioRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class PerfilUsuarioService {

	@Autowired
	private PerfilUsuarioRepository perfilUsuarioRepository;

	public List<PerfilUsuarioDto> listarTodos() {

		List<PerfilUsuarioEntity> perfilUsuarios = perfilUsuarioRepository.findAll();
		return perfilUsuarios.stream().map(PerfilUsuarioDto::new).toList();
	}

	// CREATE
	public void addPerfilUsuario(PerfilUsuarioDto PrefilUsuario) {
		PerfilUsuarioEntity perfilUsuarioEntity = new PerfilUsuarioEntity(PrefilUsuario);
		perfilUsuarioRepository.save(perfilUsuarioEntity);
	}

	// UPDATE
	public PerfilUsuarioDto alterar(PerfilUsuarioDto PerfilUsuario) {
		// cria o perfil usuario entity mandando por parametro o PerfilUsuarioDto
		PerfilUsuarioEntity perfilUsuarioEntity = new PerfilUsuarioEntity(PerfilUsuario);
		return new PerfilUsuarioDto(perfilUsuarioRepository.save(perfilUsuarioEntity));// retorna o usuario atualizado

	}

	// DELETE
	// deletar por id
	public void excluir(Long id) {
		// faz a busca do usuario por (id)
		PerfilUsuarioEntity perfilUsuarios = perfilUsuarioRepository.findById(id).get();
		perfilUsuarioRepository.delete(perfilUsuarios);

	}

	// READ
	public PerfilUsuarioDto buscarPorId(Long id) {
		return new PerfilUsuarioDto(perfilUsuarioRepository.findById(id).get());

	}

}
