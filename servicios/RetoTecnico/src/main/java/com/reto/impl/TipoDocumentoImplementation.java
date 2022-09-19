package com.reto.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.entity.TipoDocumento;
import com.reto.repository.TipoDocumentoRepository;
import com.reto.service.TipoDocumentoService;

@Service
public class TipoDocumentoImplementation implements TipoDocumentoService {

	@Autowired
	TipoDocumentoRepository repo;
	
	@Override
	public Optional<TipoDocumento> buscarTipo(int id) {
		Optional<TipoDocumento> oDoc = repo.findById(id);
		return oDoc;
	}

	@Override
	public List<TipoDocumento> listar() {
		return repo.findAll();
	}
	
}
