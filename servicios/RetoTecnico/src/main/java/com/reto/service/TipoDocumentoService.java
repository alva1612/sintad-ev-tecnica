package com.reto.service;

import java.util.List;
import java.util.Optional;

import com.reto.entity.TipoDocumento;

public interface TipoDocumentoService {
	public abstract Optional<TipoDocumento> buscarTipo(int id);
	
	public abstract List<TipoDocumento> listar();
}
