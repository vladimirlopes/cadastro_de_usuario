package com.vlsystem.cadastro.entity;

import org.springframework.beans.BeanUtils;

import com.vlsystem.cadastro.dto.PerfilDto;

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
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "SY_PERFIIL")
public class PerfilEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String descricao;
	
	public PerfilEntity(PerfilDto perfil) {
		BeanUtils.copyProperties(perfil, this);
		
	}

}
