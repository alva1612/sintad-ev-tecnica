package com.reto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reto.entity.Entidad;

public interface EntidadRepository extends JpaRepository<Entidad, Integer> {
	public abstract Optional<Entidad> findByNumdocumento(String nDoc);
}
