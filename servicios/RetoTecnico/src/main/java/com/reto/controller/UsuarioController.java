package com.reto.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto.entity.Rol;
import com.reto.entity.UserRole;
import com.reto.entity.Usuario;
import com.reto.service.UserService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins="http://localhost:4200/")
public class UsuarioController {
	
	@Autowired
	private UserService usuarioService;
	
	@PostMapping("/")
	@CrossOrigin
	public Usuario guardar(@RequestBody Usuario usuario) throws Exception{
		Set<UserRole> roles = new HashSet<>();
		
		Rol rol = new Rol();
		
		rol.setRoleId(2L);
		rol.setName("NORMAL");
		
		UserRole usuarioRol = new UserRole();
		usuarioRol.setUsuario(usuario);
		usuarioRol.setRol(rol);
		
		return usuarioService.guardarUsuario(usuario, roles);
	}
	
	@GetMapping("/{username}")
	@CrossOrigin
	public Usuario obtenerUsuario(@PathVariable("username") String username) {
		return usuarioService.obtenerUsuario(username);
	}
	
	@DeleteMapping("/{usuarioId}")
	@CrossOrigin
	public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId) {
		usuarioService.eliminarUsuario(usuarioId);
	}
}
