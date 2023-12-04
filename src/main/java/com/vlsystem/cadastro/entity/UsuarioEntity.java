package com.vlsystem.cadastro.entity;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.vlsystem.cadastro.dto.UsuarioDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "SY_USUARIO")
public class UsuarioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false, unique = true)
	private String senha;
	@Column(nullable = false)
	private String email;

	public UsuarioEntity() {

	}

	// conversão do Entity para DTO
	public UsuarioEntity(UsuarioDto usuario) {
		BeanUtils.copyProperties(usuario, this);

	}

	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioEntity other = (UsuarioEntity) obj;
		return Objects.equals(id, other.id);
	}

}
