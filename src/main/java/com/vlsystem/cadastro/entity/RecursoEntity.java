package com.vlsystem.cadastro.entity;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.vlsystem.cadastro.dto.RecursoDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
@Table(name="SY_RECURSOS")
public class RecursoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String chave;
	
	public RecursoEntity() {
		
	} 
	//conversão do Entity para o DTO
	public RecursoEntity(RecursoDto recurso) {
		BeanUtils.copyProperties(recurso, this);
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(chave, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecursoEntity other = (RecursoEntity) obj;
		return Objects.equals(chave, other.chave) && Objects.equals(id, other.id);
	}
	
	

}
