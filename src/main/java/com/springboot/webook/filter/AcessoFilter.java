package com.springboot.webook.filter;

import java.io.IOException;

import com.springboot.webook.model.Usuario;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;



public class AcessoFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Usuario usuarioLogado = (Usuario) httpServletRequest.getSession().getAttribute("usuarioLogado");
		
        if (usuarioLogado != null) {
            chain.doFilter(request, response);
        } else {
            request.setAttribute("erro", "Acesso Proibido");
            request.getRequestDispatcher("/webook/login").forward(request, response);
        }
	}

}
