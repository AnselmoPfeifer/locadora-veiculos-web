package com.anselmopfeifer.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.anselmopfeifer.dao.FabricanteDAO;
import com.anselmopfeifer.modelo.Fabricante;
import com.anselmopfeifer.util.jpa.Transactional;

public class CadastroFabricanteService implements Serializable {

	@Inject
	private FabricanteDAO fabricanteDAO;
	
	@Transactional
	public void salvar(Fabricante fabricante) throws NegocioException {
		if (fabricante.getNome() == null || fabricante.getNome().trim().equals("")) { 
			throw new NegocioException("O nome do fabricante é obrigatório");
		}
		
		this.fabricanteDAO.salvar(fabricante);
	}
	
}
