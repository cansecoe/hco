package com.hitss.swf.hco.ocupacion.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.hitss.swf.hco.capacidad.vo.FiltroRegistroCapacidad;
import com.hitss.swf.hco.model.capacidad.ConsultaRegistroCapacidad;
import com.hitss.swf.hco.ocupacion.vo.ConsultaCapacidadVO;

@Local
public interface RegistroCapacidadService {

	public ConsultaCapacidadVO consultarCapacidad(
			FiltroRegistroCapacidad filtro) throws ParseException;

	public void registrarCapacidad(
			String usuario, Date mes,
			List<ConsultaRegistroCapacidad> registroCapacidad);

}
