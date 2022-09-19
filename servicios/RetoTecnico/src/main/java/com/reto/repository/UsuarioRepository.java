package com.reto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reto.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Usuario findByUsername(String username);
}
