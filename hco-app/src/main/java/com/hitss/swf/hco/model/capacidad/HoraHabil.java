package com.hitss.swf.hco.model.capacidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class HoraHabil implements Serializable {

	private static final long serialVersionUID = -3085853729698896430L;

	@Id
	@Column(name = "ID", updatable = true, nullable = false)
	private Integer id;

	@Column(name = "HORAS")
	private Integer horas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}
}