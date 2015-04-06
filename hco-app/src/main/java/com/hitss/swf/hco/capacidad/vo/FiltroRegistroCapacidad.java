package com.hitss.swf.hco.capacidad.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hitss.swf.hco.catalogo.service.Constantes;


public class FiltroRegistroCapacidad {
	
	private Integer idGerente;
	
	private String mes;
	
	private String colaborador;
	
	private Integer idFabrica;
	
	private Integer idAreaConocimiento;
	
	private Integer idDivision;
	
	private Integer idColaborador;
	
	private String usuarioFirmado;
	
	public FiltroRegistroCapacidad() {
		this.idGerente = -1;
		this.idFabrica = -1;
		this.idAreaConocimiento = -1;
		this.idDivision = -1;
		this.idColaborador = -1;
	}

	public Integer getIdGerente() {
		return idGerente;
	}

	public void setIdGerente(Integer idGerente) {
		this.idGerente = idGerente;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getColaborador() {
		return colaborador;
	}

	public void setColaborador(String colaborador) {
		this.colaborador = colaborador;
	}

	public Integer getIdFabrica() {
		return idFabrica;
	}

	public void setIdFabrica(Integer idFabrica) {
		this.idFabrica = idFabrica;
	}

	public Integer getIdAreaConocimiento() {
		return idAreaConocimiento;
	}

	public void setIdAreaConocimiento(Integer idAreaConocimiento) {
		this.idAreaConocimiento = idAreaConocimiento;
	}

	public Integer getIdDivision() {
		return idDivision;
	}

	public void setIdDivision(Integer idDivision) {
		this.idDivision = idDivision;
	}

	public Integer getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Integer idColaborador) {
		this.idColaborador = idColaborador;
	}
	
	public Date getMesAsDate() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(Constantes.FORMATO_FECHA_FILTRO);
		return formatter.parse(mes);
	}

	public String getUsuarioFirmado() {
		return usuarioFirmado;
	}

	public void setUsuarioFirmado(String usuarioFirmado) {
		this.usuarioFirmado = usuarioFirmado;
	}

}
