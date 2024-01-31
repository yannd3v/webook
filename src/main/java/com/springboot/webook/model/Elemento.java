package com.springboot.webook.model;

import java.io.Serializable;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Elemento implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@NonNull
	@NotBlank
	@NotEmpty
    private String solicitante;
	@NonNull
	@NotBlank
	@NotEmpty
    private String numsala;
	@NonNull
	@NotBlank
	@NotEmpty
    private String data;
	@NonNull
	@NotBlank
	@NotEmpty
    private String profresp;
	@NonNull
	@NotBlank
	@NotEmpty
    private String bloco;
	@NonNull
	@NotBlank
	@NotEmpty
    private String contato;
	
	private boolean confirmado;
	
	public Elemento() {
		this.confirmado = false;
	}
	
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}
	public String getNumsala() {
		return numsala;
	}
	public void setNumsala(String numsala) {
		this.numsala = numsala;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getProfresp() {
		return profresp;
	}
	public void setProfresp(String profresp) {
		this.profresp = profresp;
	}
	public String getBloco() {
		return bloco;
	}
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public boolean isConfirmado() {
		return confirmado;
	}
	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}
	
    

    
}

