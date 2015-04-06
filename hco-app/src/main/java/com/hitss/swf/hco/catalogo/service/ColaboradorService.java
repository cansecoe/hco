package com.hitss.swf.hco.catalogo.service;

import java.util.List;

import javax.ejb.Local;

import com.hitss.swf.hco.model.catalogo.Colaborador;

@Local
public interface ColaboradorService {
	
	List<Colaborador> consultarGerentes(String numeroEmpleado);
	
	List<Colaborador> consultarPorFabrica(Integer idFabrica);

}
