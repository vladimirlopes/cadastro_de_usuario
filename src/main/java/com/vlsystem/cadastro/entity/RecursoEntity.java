package com.vlsystem.cadastro.entity;

import org.springframework.beans.BeanUtils;

import com.vlsystem.cadastro.dto.RecursoDto;

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

@Getter
@Setter
@Entity
@Table(name = "SY_RECURSOS")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class RecursoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String chave;

	// conversão do Entity para o DTO
	public RecursoEntity(RecursoDto recurso) {
		BeanUtils.copyProperties(recurso, this);

	}

}
