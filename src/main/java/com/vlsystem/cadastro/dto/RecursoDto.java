package com.vlsystem.cadastro.dto;

import org.springframework.beans.BeanUtils;

import com.vlsystem.cadastro.entity.RecursoEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecursoDto {

	private Long id;
	
	private String nome;
	
	private String chave;
	
	//conversão do DTO para o entity
	public RecursoDto(RecursoEntity recurso) {
		BeanUtils.copyProperties(recurso, this);
		
		
	}
	public RecursoDto() {
		
	}
}
