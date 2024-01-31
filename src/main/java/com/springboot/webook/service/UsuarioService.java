package com.springboot.webook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.springboot.webook.enums.TipoUsuarioEnum;
import com.springboot.webook.model.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class UsuarioService {
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private AdministradorService adminService;
	
	
	public String vericarTipoAluno(Usuario usuario, Model model, HttpServletRequest request) {
		if (alunoService.logar(usuario) != null && alunoService.logar(usuario).getTipoUser() == TipoUsuarioEnum.ALUNO){
				HttpSession session = request.getSession();
				session.setAttribute("alunoLogado", usuario);
				return "pages/paginainicial";
		}
			model.addAttribute("erro", "Usuário ou senha inválidos");
			return "pages/login";
		}
	
	public String vericarTipoAdmin(Usuario usuario, Model model, HttpServletRequest request) {
		if (adminService.logar(usuario) != null && adminService.logar(usuario).getTipoUser() == TipoUsuarioEnum.ADMINISTRADOR){
			HttpSession session = request.getSession();
			session.setAttribute("administradorLogado", usuario);
			return "pages/paginainicial";
		} 
			model.addAttribute("erro", "Usuário ou senha inválidos");
			return "pages/loginAdmin";
		}
	
	
	public boolean verificarLogado(HttpSession session) {
		Usuario usuarioLogado = (Usuario) session.getAttribute("alunoLogado");
		if (usuarioLogado != null || verificarLogadoAdministrador(session)) {
			return true;
		}
			return false;
	}
	
	public boolean verificarLogadoAdministrador(HttpSession session) {
		Usuario adminLogado = (Usuario) session.getAttribute("administradorLogado");
		if(adminLogado != null && adminLogado instanceof Usuario) {
			return true;
		} else {
			return false;
		}
	}
	
	public String invalidarSessao(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}

}
