package com.hitss.swf.hco.catalogo.service;

import java.util.List;

import javax.ejb.Local;

import com.hitss.swf.hco.model.catalogo.AreaConocimiento;
import com.hitss.swf.hco.model.catalogo.Division;
import com.hitss.swf.hco.model.catalogo.Fabrica;

@Local
public interface CatalogoService {

	List<Fabrica> consultarFabricas(int idGerente);

	List<Division> consultarDivisiones(int idGerente);

	List<AreaConocimiento> consultarAreasConocimiento(Integer idGerente);

}