package com.vlsystem.cadastro.dto;

import org.springframework.beans.BeanUtils;

import com.vlsystem.cadastro.entity.PerfilEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PerfilDto {
	
	private Long id;
	private String descricao;
	
	public PerfilDto(PerfilEntity perfil) {
		BeanUtils.copyProperties(perfil, this);
		
	}

}
