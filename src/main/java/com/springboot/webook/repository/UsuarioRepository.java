package com.springboot.webook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.webook.model.Usuario;

@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query(value="select u from Usuario u where u.email = ?1 and u.senha = ?2")
		public Usuario login(String email, String senha);
}
