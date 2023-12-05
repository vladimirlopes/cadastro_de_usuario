package com.vlsystem.cadastro.entity;

import org.springframework.beans.BeanUtils;

import com.vlsystem.cadastro.dto.UsuarioDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "SY_USUARIO")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class UsuarioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false, unique = true)
	private String senha;
	@Column(nullable = false)
	private String email;

	// conversão do Entity para DTO
	public UsuarioEntity(UsuarioDto usuario) {
		BeanUtils.copyProperties(usuario, this);

	}

}
