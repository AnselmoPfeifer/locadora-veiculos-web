package com.anselmopfeifer.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.anselmopfeifer.modelo.Fabricante;

public class FabricanteDAO implements Serializable {

	@Inject
	private EntityManager em;
	
	public void salvar(Fabricante fabricante) {
		em.persist(fabricante);
	}
	
}
