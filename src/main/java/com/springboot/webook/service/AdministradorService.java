package com.springboot.webook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.webook.model.Administrador;
import com.springboot.webook.model.Usuario;
import com.springboot.webook.repository.UsuarioRepository;


@Service
public class AdministradorService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Administrador logar(Usuario usuario) {
		try{
			return (Administrador) usuarioRepository.login(usuario.getEmail(), usuario.getSenha());
		} catch (RuntimeException e){
			e.getMessage();
		}
		  return null;
	}
	
	
}
