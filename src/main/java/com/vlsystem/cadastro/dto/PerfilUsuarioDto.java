package com.vlsystem.cadastro.dto;

import org.springframework.beans.BeanUtils;

import com.vlsystem.cadastro.entity.PerfilUsuarioEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PerfilUsuarioDto {
	private long id;
	private UsuarioDto usuario;
	private PerfilDto perfil;

	public PerfilUsuarioDto(PerfilUsuarioEntity perfilUsuario) {
		BeanUtils.copyProperties(perfilUsuario, this);
		if (perfilUsuario != null && perfilUsuario.getUsuario() != null) {
			this.usuario = new UsuarioDto(perfilUsuario.getUsuario());

		}
		if (perfilUsuario != null && perfilUsuario.getPerfil() != null) {
			this.perfil = new PerfilDto(perfilUsuario.getPerfil());
		}
	}
}
