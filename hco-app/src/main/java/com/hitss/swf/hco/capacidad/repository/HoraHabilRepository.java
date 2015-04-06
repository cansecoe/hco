package com.hitss.swf.hco.capacidad.repository;

import java.util.Date;
import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;

import com.hitss.swf.hco.model.capacidad.HoraHabil;

@Repository
public interface HoraHabilRepository extends
		EntityRepository<HoraHabil, Integer> {

	@Query(named = "RegistroCapacidad.findHorasHabiles", isNative = true)
	List<HoraHabil> consultarHorasHabiles(
			@QueryParam("horasHabiles") Integer horasHabiles,
			@QueryParam("mes") Date mes);

}
