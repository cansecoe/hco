package com.hitss.swf.hco.capacidad.repository;

import java.util.Date;
import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;

import com.hitss.swf.hco.model.capacidad.ConsultaRegistroCapacidad;

@Repository
public interface ConsultaRegistroCapacidadRepository extends
		EntityRepository<ConsultaRegistroCapacidad, Integer> {

	@Query(named = "RegistroCapacidad.findByFiltro")
	List<ConsultaRegistroCapacidad> findByFiltro(
			@QueryParam("idGerente") Integer idGerente,
			@QueryParam("mes") Date mes, 
			@QueryParam("idDivision") Integer idDivision, 
			@QueryParam("idFabrica")  Integer idFabrica, 
			@QueryParam("idAreaConocimiento") Integer idAreaConocimiento, 
			@QueryParam("idColaborador") Integer idColaborador,
			@QueryParam("semana1") Integer semana1, 
			@QueryParam("semana2") Integer semana2,
			@QueryParam("semana3") Integer semana3, 
			@QueryParam("semana4") Integer semana4, 
			@QueryParam("semana5") Integer semana5, 
			@QueryParam("usuario") String usuarioFirmado);

}
