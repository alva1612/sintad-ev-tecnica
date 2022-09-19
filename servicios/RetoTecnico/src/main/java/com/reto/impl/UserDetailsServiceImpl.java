package com.reto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.reto.entity.Usuario;
import com.reto.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Load ByUsername- DETAILSIMPL" +username);
		Usuario usuario = this.usuarioRepository.findByUsername(username);
		
		if (usuario == null) {
			throw new UsernameNotFoundException("No encontrado usuario");
		}
		return usuario;
	}

}
