package com.hitss.swf.hco.model.capacidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.hitss.swf.hco.model.catalogo.Colaborador;
import com.hitss.swf.hco.model.catalogo.Torre;

@Entity
@Table(name = "REGISTRO_CAPACIDAD")
public class RegistroCapacidad extends Bitacora {

	private static final long serialVersionUID = 901545340084890747L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_REGISTRO_CAPACIDAD", nullable = false)
	private Integer id;

	@NotNull
	@Column(name = "HORAS_SEMANA_1", nullable = false)
	private int horasSemana1;

	@NotNull
	@Column(name = "HORAS_SEMANA_2", nullable = false)
	private int horasSemana2;

	@NotNull
	@Column(name = "HORAS_SEMANA_3", nullable = false)
	private int horasSemana3;

	@NotNull
	@Column(name = "HORAS_SEMANA_4", nullable = false)
	private int horasSemana4;

	@NotNull
	@Column(name = "HORAS_SEMANA_5", nullable = false)
	private int horasSemana5;

	@NotNull
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_COLABORADOR", nullable = false)
	private Colaborador colaborador;
	
	@NotNull
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TORRE", nullable = false)
	private Torre torre;
	
	@NotNull
	@Column(name = "MES", nullable = false)
	private Date mes;
	
	public RegistroCapacidad() {
		super();
	}

	public RegistroCapacidad(String usuarioFirmado, Date mes, ConsultaRegistroCapacidad registro) {
		this.id = registro.getIdRegistroCapacidad();
		this.colaborador = new Colaborador(registro.getIdColaborador());
		this.horasSemana1 = registro.getHorasSemana1();
		this.horasSemana2 = registro.getHorasSemana2();
		this.horasSemana3 = registro.getHorasSemana3();
		this.horasSemana4 = registro.getHorasSemana4();
		this.horasSemana5 = registro.getHorasSemana5();
		this.torre = new Torre(registro.getIdTorre());
		this.setFechaRegistro(new Date());
		this.setFechaUltimaModificacion(new Date());
		this.setUsuarioModificacion(usuarioFirmado);
		this.mes = mes;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof RegistroCapacidad)) {
			return false;
		}
		RegistroCapacidad other = (RegistroCapacidad) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		if(id == null) {
			return 0;
		}
		return id.hashCode();
	}

	public int getHorasSemana1() {
		return horasSemana1;
	}

	public void setHorasSemana1(int horasSemana1) {
		this.horasSemana1 = horasSemana1;
	}

	public int getHorasSemana2() {
		return horasSemana2;
	}

	public void setHorasSemana2(int horasSemana2) {
		this.horasSemana2 = horasSemana2;
	}

	public int getHorasSemana3() {
		return horasSemana3;
	}

	public void setHorasSemana3(int horasSemana3) {
		this.horasSemana3 = horasSemana3;
	}

	public int getHorasSemana4() {
		return horasSemana4;
	}

	public void setHorasSemana4(int horasSemana4) {
		this.horasSemana4 = horasSemana4;
	}

	public int getHorasSemana5() {
		return horasSemana5;
	}

	public void setHorasSemana5(int horasSemana5) {
		this.horasSemana5 = horasSemana5;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Torre getTorre() {
		return torre;
	}

	public void setTorre(Torre torre) {
		this.torre = torre;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		result += "horasSemana1: " + horasSemana1;
		result += ", horasSemana2: " + horasSemana2;
		result += ", horasSemana3: " + horasSemana3;
		result += ", horasSemana4: " + horasSemana4;
		result += ", horasSemana5: " + horasSemana5;
		return result;
	}
}