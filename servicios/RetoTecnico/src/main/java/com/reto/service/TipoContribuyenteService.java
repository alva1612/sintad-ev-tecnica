package com.reto.service;

import java.util.List;
import java.util.Optional;

import com.reto.entity.TipoContribuyente;

public interface TipoContribuyenteService {
	public abstract Optional<TipoContribuyente> buscarTipo(int id);
	
	public abstract List<TipoContribuyente> listar();
}
