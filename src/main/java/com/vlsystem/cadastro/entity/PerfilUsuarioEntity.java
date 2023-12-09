package com.vlsystem.cadastro.entity;

import org.springframework.beans.BeanUtils;

import com.vlsystem.cadastro.dto.PerfilUsuarioDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "SY_PERFIL_USUARIO")
public class PerfilUsuarioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private UsuarioEntity usuario;
	
	@ManyToOne
	@JoinColumn(name = "ID_PERFIL")
	private PerfilEntity perfil;
	
	public PerfilUsuarioEntity(PerfilUsuarioDto perfilUsuario) {
		BeanUtils.copyProperties(perfilUsuario, this);
		if (perfilUsuario != null && perfilUsuario.getUsuario() != null) {
			this.usuario = new UsuarioEntity(perfilUsuario.getUsuario());

		}
		if (perfilUsuario != null && perfilUsuario.getPerfil() != null) {
			this.perfil = new PerfilEntity(perfilUsuario.getPerfil());
		}
	}

}
