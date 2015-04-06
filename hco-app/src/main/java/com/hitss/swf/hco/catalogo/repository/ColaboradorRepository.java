package com.hitss.swf.hco.catalogo.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

import com.hitss.swf.hco.model.catalogo.Colaborador;
import com.hitss.swf.hco.model.catalogo.Fabrica;
import com.hitss.swf.hco.model.catalogo.RolEmpleado;

@Repository
public interface ColaboradorRepository extends
		EntityRepository<Colaborador, Integer> {
	
	@Query("SELECT c FROM Colaborador c INNER JOIN FETCH c.rol r INNER JOIN FETCH c.superiores s WHERE c.numeroEmpleado = ?1")
	Colaborador findByNumeroEmpleado(String numeroEmpleado);
	
	List<Colaborador> findByRol(RolEmpleado rol);
	
	@Query(named = "Colaborador.findByFabrica")
	List<Colaborador> findByFabrica(Fabrica fabrica);

}
