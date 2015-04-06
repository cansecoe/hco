package com.hitss.swf.hco.catalogo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.hitss.swf.hco.catalogo.repository.ColaboradorRepository;
import com.hitss.swf.hco.catalogo.service.ColaboradorService;
import com.hitss.swf.hco.model.catalogo.Colaborador;
import com.hitss.swf.hco.model.catalogo.Fabrica;
import com.hitss.swf.hco.model.catalogo.RolEmpleado;

@Stateless
public class ColaboradorServiceImpl implements ColaboradorService {
	
	@Inject
	private ColaboradorRepository colaboradorRepository;

	@Override
	public List<Colaborador> consultarGerentes(String numeroEmpleado) {
		Colaborador firmado = colaboradorRepository.findByNumeroEmpleado(numeroEmpleado);
		if(RolEmpleado.DIRECTOR.equals(firmado.getRol()) || RolEmpleado.GERENTE.equals(firmado.getRol())) {
			return colaboradorRepository.findByRol(RolEmpleado.GERENTE);
		} else if(RolEmpleado.COORDINADOR.equals(firmado.getRol())) {
			return new ArrayList<Colaborador>(firmado.getSuperiores());
		} else {
			return new ArrayList<Colaborador>();
		}
	}

	@Override
	public List<Colaborador> consultarPorFabrica(Integer idFabrica) {
		return colaboradorRepository.findByFabrica(new Fabrica(idFabrica));
	}

}
