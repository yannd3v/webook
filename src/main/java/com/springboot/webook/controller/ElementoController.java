package com.springboot.webook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.springboot.webook.model.Elemento;
import com.springboot.webook.service.ElementoService;
import com.springboot.webook.service.UsuarioService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ElementoController {

	@Autowired
	private ElementoService elementService;
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("webook/salvar")
	public String salvarElementos(@Valid Elemento elementos, BindingResult bindingResult, Model model) {
		if (elementService.inserirElementos(elementos, bindingResult, model)) {
			return "pages/paginainicial";
		}
			return "pages/paginainicial";
	}

	@GetMapping("webook/lista-reservas")
	public String exibirElementos(Model model, HttpSession session) {
		if (usuarioService.verificarLogado(session)) {
			elementService.listarElementos(model);
			return "pages/listarReservas";
		}
			return "redirect:login";
	}

	

	@PostMapping("*/confirmar")
	public String confirmarElementos(@RequestParam Long id, HttpSession session, Model model) {
		if (usuarioService.verificarLogadoAdministrador(session)) {
			elementService.confirmarElemento(id);
			return "pages/paginainicial";
		}
			model.addAttribute("erro", "Você não tem permissão para confirmar reservas");
			return "pages/paginainicial";
	}

	@PostMapping("*/excluir")
	public String excluirElementos(@RequestParam Long id, HttpSession session, Model model) {
		if (usuarioService.verificarLogadoAdministrador(session)) {
			elementService.excluirElemento(id);
			return "redirect:/webook/lista-reservas";
		}
			model.addAttribute("erro", "Você não tem permissão para excluir reservas.");
			return "pages/paginainicial";
	}

	@PostMapping("*/editarElementos")
	public String editarElementos(@ModelAttribute Elemento elemento, HttpSession session, Model model) {
		if (usuarioService.verificarLogadoAdministrador(session)) {
			elementService.editarElemento(elemento);
			return "pages/paginainicial";
		}
			model.addAttribute("erro", "Você não tem permissão para editar reservas.");
			return "pages/paginainicial";
	}

	@GetMapping("*/editar")
	public String exibirFormularioEdicao(@RequestParam Long id, Model model, HttpSession session, Elemento elemento) {
		if (usuarioService.verificarLogadoAdministrador(session)) {
			elementService.buscarId(id, elemento, model);
			return "pages/editarReserva";
		}
			model.addAttribute("erro", "Você não tem permissão para editar reservas.");
			return "pages/paginainicial";
	}
}
