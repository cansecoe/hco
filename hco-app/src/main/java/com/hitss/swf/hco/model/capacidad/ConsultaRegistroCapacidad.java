package com.hitss.swf.hco.model.capacidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CONSULTA_REGISTRO_CAPACIDAD")
public class ConsultaRegistroCapacidad {

	@Id
	@Column(name = "ID_COLABORADOR", updatable = false, nullable = false)
	private Integer idColaborador;

	@Column(name = "COLABORADOR")
	private String colaborador;

	@Column(name = "FABRICA")
	private String fabrica;

	@Column(name = "TORRE")
	private String torre;

	@Column(name = "AREA_CONOCIMIENTO")
	private String areaConocimiento;

	@Column(name = "UBICACION")
	private String ubicacion;

	@Column(name = "DIVISION")
	private String division;

	@Column(name = "SEMANA_1")
	private Integer horasSemana1;

	@Column(name = "SEMANA_2")
	private Integer horasSemana2;

	@Column(name = "SEMANA_3")
	private Integer horasSemana3;

	@Column(name = "SEMANA_4")
	private Integer horasSemana4;

	@Column(name = "SEMANA_5")
	private Integer horasSemana5;

	@Column(name = "CAPACIDAD_MES")
	private Integer capacidadMensual;

	@Column(name = "INCIDENTES")
	private Integer incidentes;

	@Column(name = "CAPACIDAD_PRODUCTIVA")
	private Integer capacidadProductiva;

	@Column(name = "HORAS_OTRA_FABRICA")
	private Integer capacidadOtraFabrica;

	@Column(name = "ID_GERENTE")
	private Integer idGerente;

	@Column(name = "ID_REGISTRO_CAPACIDAD", nullable = true)
	private Integer idRegistroCapacidad;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MES", nullable = true)
	private Date mes;

	@Column(name = "ID_AREA_CONOCIMIENTO")
	private Integer idAreaConocimiento;

	@Column(name = "ID_FABRICA")
	private Integer idFabrica;

	@Column(name = "ID_DIVISION")
	private Integer idDivision;

	@Column(name = "ID_TORRE")
	private Integer idTorre;

	@Column(name = "MES_INCIDENTE")
	private Date mesIncidente;

	@Column(name = "HORAS_INCIDENTE")
	private Integer horasIncidente;

	@Column(name = "GERENTE")
	private String gerente;

	@Column(name = "PERMISO")
	private String usuarioPermiso;

	@Column(name = "EDICION")
	private Boolean edicion;

	public ConsultaRegistroCapacidad() {
		super();
	}

	public ConsultaRegistroCapacidad(Integer idColaborador, String colaborador,
			String fabrica, String torre, String areaConocimiento,
			String ubicacion, String division, Integer horasSemana1,
			Integer horasSemana2, Integer horasSemana3, Integer horasSemana4,
			Integer horasSemana5, Integer incidentes,
			Integer capacidadOtraFabrica, Integer idGerente,
			Integer idRegistroCapacidad, Date mes, Integer idAreaConocimiento,
			Integer idFabrica, Integer idDivision, Integer idTorre,
			Boolean edicion) {
		super();
		this.idColaborador = idColaborador;
		this.colaborador = colaborador;
		this.fabrica = fabrica;
		this.torre = torre;
		this.areaConocimiento = areaConocimiento;
		this.ubicacion = ubicacion;
		this.division = division;
		this.horasSemana1 = horasSemana1;
		this.horasSemana2 = horasSemana2;
		this.horasSemana3 = horasSemana3;
		this.horasSemana4 = horasSemana4;
		this.horasSemana5 = horasSemana5;
		this.capacidadMensual = horasSemana1 + horasSemana2 + horasSemana3
				+ horasSemana4 + horasSemana5;
		this.incidentes = incidentes;
		this.capacidadProductiva = capacidadMensual - incidentes;
		this.capacidadOtraFabrica = capacidadOtraFabrica;
		this.idGerente = idGerente;
		this.idRegistroCapacidad = idRegistroCapacidad;
		this.mes = mes;
		this.idAreaConocimiento = idAreaConocimiento;
		this.idFabrica = idFabrica;
		this.idDivision = idDivision;
		this.idTorre = idTorre;
		this.edicion = edicion;
	}

	public String getColaborador() {
		return colaborador;
	}

	public void setColaborador(String colaborador) {
		this.colaborador = colaborador;
	}

	public String getFabrica() {
		return fabrica;
	}

	public void setFabrica(String fabrica) {
		this.fabrica = fabrica;
	}

	public String getTorre() {
		return torre;
	}

	public void setTorre(String torre) {
		this.torre = torre;
	}

	public String getAreaConocimiento() {
		return areaConocimiento;
	}

	public void setAreaConocimiento(String areaConocimiento) {
		this.areaConocimiento = areaConocimiento;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public Integer getHorasSemana1() {
		return horasSemana1;
	}

	public void setHorasSemana1(Integer horasSemana1) {
		this.horasSemana1 = horasSemana1;
	}

	public Integer getHorasSemana2() {
		return horasSemana2;
	}

	public void setHorasSemana2(Integer horasSemana2) {
		this.horasSemana2 = horasSemana2;
	}

	public Integer getHorasSemana3() {
		return horasSemana3;
	}

	public void setHorasSemana3(Integer horasSemana3) {
		this.horasSemana3 = horasSemana3;
	}

	public Integer getHorasSemana4() {
		return horasSemana4;
	}

	public void setHorasSemana4(Integer horasSemana4) {
		this.horasSemana4 = horasSemana4;
	}

	public Integer getHorasSemana5() {
		return horasSemana5;
	}

	public void setHorasSemana5(Integer horasSemana5) {
		this.horasSemana5 = horasSemana5;
	}

	public Integer getCapacidadMensual() {
		return capacidadMensual;
	}

	public void setCapacidadMensual(Integer capacidadMensual) {
		this.capacidadMensual = capacidadMensual;
	}

	public Integer getIncidentes() {
		return incidentes;
	}

	public void setIncidentes(Integer incidentes) {
		this.incidentes = incidentes;
	}

	public Integer getCapacidadProductiva() {
		return capacidadProductiva;
	}

	public void setCapacidadProductiva(Integer capacidadProductiva) {
		this.capacidadProductiva = capacidadProductiva;
	}

	public Integer getCapacidadOtraFabrica() {
		return capacidadOtraFabrica;
	}

	public void setCapacidadOtraFabrica(Integer capacidadOtraFabrica) {
		this.capacidadOtraFabrica = capacidadOtraFabrica;
	}

	public Integer getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Integer idColaborador) {
		this.idColaborador = idColaborador;
	}

	public Integer getIdGerente() {
		return idGerente;
	}

	public void setIdGerente(Integer idGerente) {
		this.idGerente = idGerente;
	}

	public Date getMes() {
		return mes;
	}

	public void setMes(Date mes) {
		this.mes = mes;
	}

	public Integer getIdAreaConocimiento() {
		return idAreaConocimiento;
	}

	public void setIdAreaConocimiento(Integer idAreaConocimiento) {
		this.idAreaConocimiento = idAreaConocimiento;
	}

	public Integer getIdFabrica() {
		return idFabrica;
	}

	public void setIdFabrica(Integer idFabrica) {
		this.idFabrica = idFabrica;
	}

	public Integer getIdDivision() {
		return idDivision;
	}

	public void setIdDivision(Integer idDivision) {
		this.idDivision = idDivision;
	}

	public Integer getIdRegistroCapacidad() {
		return idRegistroCapacidad;
	}

	public void setIdRegistroCapacidad(Integer idRegistroCapacidad) {
		this.idRegistroCapacidad = idRegistroCapacidad;
	}

	public Integer getIdTorre() {
		return idTorre;
	}

	public void setIdTorre(Integer idTorre) {
		this.idTorre = idTorre;
	}

	public Date getMesIncidente() {
		return mesIncidente;
	}

	public void setMesIncidente(Date mesIncidente) {
		this.mesIncidente = mesIncidente;
	}

	public Integer getHorasIncidente() {
		return horasIncidente;
	}

	public void setHorasIncidente(Integer horasIncidente) {
		this.horasIncidente = horasIncidente;
	}

	public String getGerente() {
		return gerente;
	}

	public void setGerente(String gerente) {
		this.gerente = gerente;
	}

	public String getUsuarioPermiso() {
		return usuarioPermiso;
	}

	public void setUsuarioPermiso(String usuarioPermiso) {
		this.usuarioPermiso = usuarioPermiso;
	}

	public Boolean getEdicion() {
		return edicion;
	}

	public void setEdicion(Boolean edicion) {
		this.edicion = edicion;
	}

}
