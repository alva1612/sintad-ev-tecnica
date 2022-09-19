package com.reto.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.entity.TipoContribuyente;
import com.reto.repository.TipoContribuyenteRepository;
import com.reto.service.TipoContribuyenteService;

@Service
public class TipoContribuyenteImplementation implements TipoContribuyenteService {
	
	@Autowired
	TipoContribuyenteRepository repo;
	
	@Override
	public Optional<TipoContribuyente> buscarTipo(int id) {
		return repo.findById(id); 
	}

	@Override
	public List<TipoContribuyente> listar() {
		return repo.findAll();
	}
	
}
