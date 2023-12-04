package com.vlsystem.cadastro.dto;

import org.springframework.beans.BeanUtils;

import com.vlsystem.cadastro.entity.UsuarioEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {
	private Long id;

	private String nome;

	private String login;

	private String senha;

	private String email;

	public UsuarioDto() {

	}

	// conversão do Dto para Entity
	public UsuarioDto(UsuarioEntity usuario) {
		BeanUtils.copyProperties(usuario, this);

	}

}
