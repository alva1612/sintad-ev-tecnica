package com.reto.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.entity.UserRole;
import com.reto.entity.Usuario;
import com.reto.repository.RoleRepository;
import com.reto.repository.UsuarioRepository;
import com.reto.service.UserService;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UsuarioRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;

	@Override
	public Usuario guardarUsuario(Usuario usuario, Set<UserRole> usuarioRoles) throws Exception {
		Usuario usuarioLocal = userRepo.findByUsername(usuario.getUsername());
		if (usuarioLocal != null) {
			System.out.println("Usuario ya existe");
			throw new Exception("Usuario ya existe");
		} else {
			for (UserRole usuarioRol:usuarioRoles) {
				roleRepo.save(usuarioRol.getRol());
			}
			usuario.getUsuarioRoles().addAll(usuarioRoles);
			usuarioLocal = userRepo.save(usuario);
		}
		return usuarioLocal;
	}

	@Override
	public Usuario obtenerUsuario(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public void eliminarUsuario(Long usuarioId) {
		userRepo.deleteById(usuarioId);
	}
}
