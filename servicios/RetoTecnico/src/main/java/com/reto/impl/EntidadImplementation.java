package com.reto.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.entity.Entidad;
import com.reto.entity.EntidadDTO;
import com.reto.entity.TipoContribuyente;
import com.reto.entity.TipoDocumento;
import com.reto.repository.EntidadRepository;
import com.reto.repository.TipoContribuyenteRepository;
import com.reto.repository.TipoDocumentoRepository;
import com.reto.service.EntidadService;

@Service
public class EntidadImplementation implements EntidadService {
	
	@Autowired
	private EntidadRepository repo;

	@Autowired
	private TipoDocumentoRepository dRepo;
	@Autowired
	private TipoContribuyenteRepository cRepo;
	
	@Override
	public List<Entidad> listaEntidad() {
		return repo.findAll();
	}

	@Override
	public Entidad insertaEntidad(EntidadDTO obj) {
		Entidad toSave = new Entidad();
		
		toSave.setId(obj.getId());
		toSave.setEstado(obj.isEstado());
		toSave.setDireccion(obj.getDireccion());
		toSave.setNomComercial(obj.getNomComercial());
		toSave.setNumdocumento(obj.getNumdocumento());
		toSave.setRazonSocial(obj.getRazonSocial());
		toSave.setTelefono(obj.getTelefono());
		
		Optional<TipoContribuyente> oCont = cRepo.findById(obj.getTipoContribuyente());
		if (oCont.isPresent()) {
			toSave.setTipoContribuyente(oCont.get());
		}
		
		Optional<TipoDocumento> oDoc = dRepo.findById(obj.getTipoDocumento());
		if (oDoc.isPresent()) {
			toSave.setTipoDocumento(oDoc.get());
		}
		return repo.save(toSave);
	}

	@Override
	public Optional<Entidad> buscarEntidadId(int id) {
		return repo.findById(id);
	}

	@Override
	public Optional<Entidad> buscarEntidadNumDoc(String nDoc) {
		return repo.findByNumdocumento(nDoc);
	}

	@Override
	public void eliminaEntidad(int id) {
		repo.deleteById(id);
	}
	
	
	
}
