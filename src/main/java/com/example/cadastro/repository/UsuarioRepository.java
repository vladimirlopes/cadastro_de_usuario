package com.example.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cadastro.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

}
