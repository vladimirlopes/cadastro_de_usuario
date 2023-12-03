package com.example.cadastro.dto;

import org.springframework.beans.BeanUtils;

import com.example.cadastro.entity.UsuarioEntity;

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
	
	//conversão do ENTITY para DTO
	public UsuarioDto(UsuarioEntity usuario) {
		BeanUtils.copyProperties(usuario, this);;
		
		
	}
	public UsuarioDto() {
		
	}
}
