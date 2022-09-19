package com.reto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reto.entity.TipoContribuyente;
import com.reto.service.TipoContribuyenteService;

@CrossOrigin(origins="http://localhost:4200/")
@RestController
@RequestMapping("/tcontribuyente")
public class TipoContribuyenteController {
	
	@Autowired
	TipoContribuyenteService service;
	
	@GetMapping
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<List<TipoContribuyente>> listar() {
		List<TipoContribuyente> lst = service.listar();
		return ResponseEntity.ok(lst);
	}
	
}
