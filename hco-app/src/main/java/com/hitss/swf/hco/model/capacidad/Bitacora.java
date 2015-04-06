package com.hitss.swf.hco.model.capacidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class Bitacora implements Serializable{
	
	private static final long serialVersionUID = 151766175792162717L;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_REGISTRO", nullable = false)
	private Date fechaRegistro;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_ULTIMA_MODIFICACION", nullable = false)
	private Date fechaUltimaModificacion;
	
	@NotNull
	@Column(name = "USUARIO_MODIFICACION", nullable = false)
	private String usuarioModificacion;

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

}
