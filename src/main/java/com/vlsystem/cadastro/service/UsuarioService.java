package com.vlsystem.cadastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlsystem.cadastro.dto.UsuarioDto;
import com.vlsystem.cadastro.entity.UsuarioEntity;
import com.vlsystem.cadastro.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	// READ
	// busca todos os usuarios do repositorio
	public List<UsuarioDto> listarTodos() {
		// consulta o UsuarioEntity no repositoio e faz a busca no usuarioRepository
		List<UsuarioEntity> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(UsuarioDto::new).toList();// percorre a lista de usuario que buscou
	}

	// CREATE
	// adiciona usuarios ao banco de dados passando UsuarioDto como parametro
	public void addUsuario(UsuarioDto usuario) {
		// cria o usuario entity mandando por parametro o UsuarioDto que veio
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		usuarioRepository.save(usuarioEntity);
	}

	// UPDATE
	public UsuarioDto alterar(UsuarioDto usuario) {
		// cria o usuario entity mandando por parametro o UsuarioDto
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		return new UsuarioDto(usuarioRepository.save(usuarioEntity));// retorna o usuario atualizado

	}

	// DELETE
	// deletar por id
	public void excluir(Long id) {
		// faz a busca do usuario por (id)
		UsuarioEntity usuarios = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuarios);// deleta o usuario no banco

	}

	// READ
	// faz a busca do usuario por (id)
	/**
	public UsuarioDto buscarPorId(Long id) {
		return new UsuarioDto(usuarioRepository.findById(id).get());

	}*/
}
