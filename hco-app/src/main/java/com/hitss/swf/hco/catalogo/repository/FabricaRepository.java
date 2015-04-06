package com.hitss.swf.hco.catalogo.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import com.hitss.swf.hco.model.catalogo.Colaborador;
import com.hitss.swf.hco.model.catalogo.Fabrica;

@Repository
public interface FabricaRepository extends EntityRepository<Fabrica, Integer>{
	
	List<Fabrica> findByGerente(Colaborador gerente);

}
