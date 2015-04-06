package com.hitss.swf.hco.ocupacion.vo;

import java.util.List;

import com.hitss.swf.hco.model.capacidad.ConsultaRegistroCapacidad;

public class ConsultaCapacidadVO {

	private Integer capacidadMensual;

	private List<ConsultaRegistroCapacidad> capacidades;

	public ConsultaCapacidadVO(Integer capacidadMensual,
			List<ConsultaRegistroCapacidad> capacidades) {
		this.capacidadMensual = capacidadMensual;
		this.capacidades = capacidades;
	}

	public Integer getCapacidadMensual() {
		return capacidadMensual;
	}

	public List<ConsultaRegistroCapacidad> getCapacidades() {
		return capacidades;
	}

}
