package com.hitss.swf.hco.catalogo.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

import com.hitss.swf.hco.model.catalogo.Colaborador;
import com.hitss.swf.hco.model.catalogo.Division;

@Repository
public interface DivisionRepository extends EntityRepository<Division, Integer>{
	
	@Query(named="Division.findByGerente")
	List<Division> findByGerente(Colaborador gerente);

}
