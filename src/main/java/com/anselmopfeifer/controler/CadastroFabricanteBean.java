package com.anselmopfeifer.controler;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.anselmopfeifer.modelo.Fabricante;
import com.anselmopfeifer.service.CadastroFabricanteService;
import com.anselmopfeifer.service.NegocioException;
import com.anselmopfeifer.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroFabricanteBean implements Serializable {

	@Inject
	private CadastroFabricanteService cadastroFabricanteService;
	
	private Fabricante fabricante;
	
	public void salvar() {
		try {
			this.cadastroFabricanteService.salvar(fabricante);
			FacesUtil.addSuccessMessage("Fabricante salvo com sucesso!");
			
			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	@PostConstruct
	public void init() {
		this.limpar();
	}
	
	public void limpar() {
		this.fabricante = new Fabricante();
	}

	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
}