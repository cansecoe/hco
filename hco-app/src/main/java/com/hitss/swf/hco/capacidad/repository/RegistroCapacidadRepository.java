package com.hitss.swf.hco.capacidad.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import com.hitss.swf.hco.model.capacidad.RegistroCapacidad;

@Repository
public interface RegistroCapacidadRepository extends EntityRepository<RegistroCapacidad, Integer> {

}
