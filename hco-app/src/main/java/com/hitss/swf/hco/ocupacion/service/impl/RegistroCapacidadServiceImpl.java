package com.hitss.swf.hco.ocupacion.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.hitss.swf.hco.capacidad.repository.ConsultaRegistroCapacidadRepository;
import com.hitss.swf.hco.capacidad.repository.HoraHabilRepository;
import com.hitss.swf.hco.capacidad.repository.RegistroCapacidadRepository;
import com.hitss.swf.hco.capacidad.vo.FiltroRegistroCapacidad;
import com.hitss.swf.hco.catalogo.service.Constantes;
import com.hitss.swf.hco.model.capacidad.ConsultaRegistroCapacidad;
import com.hitss.swf.hco.model.capacidad.HoraHabil;
import com.hitss.swf.hco.model.capacidad.RegistroCapacidad;
import com.hitss.swf.hco.ocupacion.service.RegistroCapacidadService;
import com.hitss.swf.hco.ocupacion.vo.ConsultaCapacidadVO;

/**
 * Servicios disponibles para Registro de Capacidad
 * 
 * @author Hitss
 */
@Stateless
public class RegistroCapacidadServiceImpl implements RegistroCapacidadService {

	@Inject
	private ConsultaRegistroCapacidadRepository capacidadRepository;

	@Inject
	private RegistroCapacidadRepository registroRepository;

	@Inject
	private HoraHabilRepository horaHabilRepository;

	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public ConsultaCapacidadVO consultarCapacidad(FiltroRegistroCapacidad filtro)
			throws ParseException {
		Date mes = filtro.getMesAsDate();
		List<HoraHabil> horasHabiles = horaHabilRepository
				.consultarHorasHabiles(Constantes.HORAS_HABILES, mes);
		return new ConsultaCapacidadVO(sumarHorasHabiles(horasHabiles),
				capacidadRepository.findByFiltro(filtro.getIdGerente(), mes,
						filtro.getIdDivision(), filtro.getIdFabrica(), filtro
								.getIdAreaConocimiento(), filtro
								.getIdColaborador(), horasHabiles.get(0)
								.getHoras(), horasHabiles.get(1).getHoras(),
						horasHabiles.get(2).getHoras(), horasHabiles.get(3)
								.getHoras(),
						obtenerValorUltimaSemana(horasHabiles),
						filtro.getUsuarioFirmado()));
	}

	private Integer sumarHorasHabiles(List<HoraHabil> horasHabiles) {
		Integer suma = 0;
		for (HoraHabil hora : horasHabiles) {
			suma += hora.getHoras();
		}

		return suma;
	}

	private Integer obtenerValorUltimaSemana(List<HoraHabil> horasHabiles) {
		if (horasHabiles.size() == 5) {
			return horasHabiles.get(4).getHoras();
		} else {
			return 0;
		}
	}

	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public void registrarCapacidad(String usuarioFirmado, Date mes,
			List<ConsultaRegistroCapacidad> registroCapacidad) {
		for (ConsultaRegistroCapacidad registro : registroCapacidad) {
			RegistroCapacidad newRegistro = new RegistroCapacidad(usuarioFirmado, mes, registro);
			registroRepository.save(newRegistro);
		}
	}
}
