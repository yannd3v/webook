package com.springboot.webook.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.springboot.webook.model.Elemento;
import com.springboot.webook.repository.ElementoRepository;

@Service
public class ElementoService {

    @Autowired
    private ElementoRepository elementRepository;

    @Transactional
    public boolean inserirElementos(Elemento elementos, BindingResult bindingResult, Model model) {
    	if(bindingResult.hasErrors()) {
    		model.addAttribute("erro", "Há espaços em branco. Verifique os campos.");
    		return false;
    	}
	        elementRepository.save(elementos);
	        return true;   
    }
    
    @Transactional
    public void editarElemento(Elemento elementos) {
    	elementRepository.save(elementos);
    }
    
    @Transactional
    public String listarElementos(Model model) {
    	List<Elemento> elementos = elementRepository.findAll();
    	model.addAttribute("reservas", elementos);
		return "pages/listarReservas";
    }
    
    @Transactional
    public void confirmarElemento(Long id) {
    	elementRepository.confirmar(id);
    }
    
    @Transactional
    public void excluirElemento(Long id) {
    	elementRepository.deleteById(id);
    }
    
    @Transactional
    public Elemento buscarId(Long id, Elemento elemento, Model model) {
    	model.addAttribute("elemento", elemento);
    	return elemento = elementRepository.getReferenceById(id);
    }
}

