package com.vlsystem.cadastro.dto;

import org.springframework.beans.BeanUtils;

import com.vlsystem.cadastro.entity.PermissaoPerfilRecursoEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PermissaoPerfilRecursoDto {
	private Long id;
	private PerfilDto perfil;	
	private RecursoDto recurso;
	
	public PermissaoPerfilRecursoDto(PermissaoPerfilRecursoEntity permissaoPerfilRecurso) {
		BeanUtils.copyProperties(permissaoPerfilRecurso, this);
		if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getRecurso() != null) {
			this.recurso = new RecursoDto(permissaoPerfilRecurso.getRecurso());
		}
		if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getPerfil() != null) {
			this.perfil = new PerfilDto(permissaoPerfilRecurso.getPerfil());
		}		
	}

}
