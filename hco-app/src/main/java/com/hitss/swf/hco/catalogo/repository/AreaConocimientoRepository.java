package com.hitss.swf.hco.catalogo.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

import com.hitss.swf.hco.model.catalogo.AreaConocimiento;
import com.hitss.swf.hco.model.catalogo.Colaborador;

@Repository
public interface AreaConocimientoRepository extends EntityRepository<AreaConocimiento, Integer>{
	
	@Query(named = "AreaConocimiento.findByGerente")
	List<AreaConocimiento> findByGerente(Colaborador gerente);

}
