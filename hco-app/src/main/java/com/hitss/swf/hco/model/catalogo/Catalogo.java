package com.hitss.swf.hco.model.catalogo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Catalogo  implements Serializable{
	
	private static final long serialVersionUID = -544601555488252284L;

	@Column(name = "CODIGO", length = 10)
	protected String codigo;
	
	@Column(name = "NOMBRE", length = 50)
	protected String nombre;
	
	@Column(name = "ESTADO")
	protected Boolean estado;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
