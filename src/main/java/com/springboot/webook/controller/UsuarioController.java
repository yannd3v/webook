package com.springboot.webook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.webook.model.Aluno;
import com.springboot.webook.model.Usuario;
import com.springboot.webook.service.AdministradorService;
import com.springboot.webook.service.AlunoService;
import com.springboot.webook.service.UsuarioService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired 
	private AlunoService alunoService;
	
	@Autowired
	private AdministradorService adminService;

	@GetMapping("webook/login")
	public String start() {
		return "pages/login";
	}

	@GetMapping("webook/adminlogin")
	public String telaLogin(){
		return "pages/loginAdmin";
	}

	@PostMapping("webook/login")
	public String salvar(Aluno aluno) {
		return alunoService.salvar(aluno);
	}

	@PostMapping("webook/home")
	public String entrar(Model model, Usuario usuario, HttpServletRequest request) {
		this.alunoService.logar(usuario);
		return usuarioService.vericarTipoAluno(usuario, model, request);
	}
	
	@PostMapping("webook/homeadmin")
	public String entrarAdmin(Model model, Usuario usuario, HttpServletRequest request) {
		this.adminService.logar(usuario);
		return usuarioService.vericarTipoAdmin(usuario, model, request);
	}

	@GetMapping("webook/home")
	public String voltar(HttpSession session) {
		if(usuarioService.verificarLogado(session)) {
			return "pages/paginainicial";
		}
			return "pages/login";	
	}

	@GetMapping("*/logout")
	public String logout(HttpSession session) {
		return usuarioService.invalidarSessao(session);
	}

}
