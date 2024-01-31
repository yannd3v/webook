package com.springboot.webook.model;

import com.springboot.webook.enums.TipoUsuarioEnum;

import jakarta.persistence.Entity;

@Entity
public class Administrador extends Usuario{

	private static final long serialVersionUID = 1L;
	
	public Administrador() {
		 super.setTipoUser(TipoUsuarioEnum.ADMINISTRADOR);
	}

}
