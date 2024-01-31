package com.springboot.webook.model;

import java.io.Serializable;

import org.springframework.lang.NonNull;

import com.springboot.webook.enums.TipoUsuarioEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NonNull
	@NotBlank
	@NotEmpty
	private String nome;
	@NonNull
	@NotBlank
	@NotEmpty
	private String senha;
	@NonNull
	@NotBlank
	@NotEmpty
	private String email;
	
	@Enumerated(EnumType.STRING)
	private TipoUsuarioEnum tipoUser;
	
	public Usuario() {
		
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public TipoUsuarioEnum getTipoUser() {
		return tipoUser;
	}
	public void setTipoUser(TipoUsuarioEnum tipoUser) {
		this.tipoUser = tipoUser;
	}
	
}
