package com.vlsystem.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vlsystem.cadastro.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

}
