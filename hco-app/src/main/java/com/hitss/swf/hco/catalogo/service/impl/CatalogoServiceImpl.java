package com.hitss.swf.hco.catalogo.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.hitss.swf.hco.catalogo.repository.AreaConocimientoRepository;
import com.hitss.swf.hco.catalogo.repository.DivisionRepository;
import com.hitss.swf.hco.catalogo.repository.FabricaRepository;
import com.hitss.swf.hco.catalogo.service.CatalogoService;
import com.hitss.swf.hco.model.catalogo.AreaConocimiento;
import com.hitss.swf.hco.model.catalogo.Colaborador;
import com.hitss.swf.hco.model.catalogo.Division;
import com.hitss.swf.hco.model.catalogo.Fabrica;

@Stateless
public class CatalogoServiceImpl implements CatalogoService {

	@Inject
	private FabricaRepository fabricaRepository;

	@Inject
	private DivisionRepository divisionRepository;

	@Inject
	private AreaConocimientoRepository areaRepository;

	@Override
	public List<Fabrica> consultarFabricas(int idGerente) {
		return fabricaRepository.findByGerente(new Colaborador(idGerente));
	}

	@Override
	public List<Division> consultarDivisiones(int idGerente) {
		return divisionRepository.findByGerente(new Colaborador(idGerente));
	}

	@Override
	public List<AreaConocimiento> consultarAreasConocimiento(Integer idGerente) {
		return areaRepository.findByGerente(new Colaborador(idGerente));
	}

}