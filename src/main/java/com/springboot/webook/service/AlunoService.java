package com.springboot.webook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.webook.enums.TipoUsuarioEnum;
import com.springboot.webook.model.Aluno;
import com.springboot.webook.model.Usuario;
import com.springboot.webook.repository.UsuarioRepository;

@Service
public class AlunoService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Aluno logar(Usuario usuario) {
		try{
			return (Aluno) usuarioRepository.login(usuario.getEmail(), usuario.getSenha());
		} catch (RuntimeException e){
			e.getMessage();
		}
		  return null;
	}
	
	@Transactional
	public String salvar(Aluno aluno) {
		aluno.setTipoUser(TipoUsuarioEnum.ALUNO);
		usuarioRepository.save(aluno);
		return "pages/login";
	}
}
