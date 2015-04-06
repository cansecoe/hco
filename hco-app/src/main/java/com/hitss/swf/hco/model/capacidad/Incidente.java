package com.hitss.swf.hco.model.capacidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "INCIDENTE")
public class Incidente extends Bitacora {
	
	private static final long serialVersionUID = 8065464419809678146L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_INCIDENTE", updatable = false, nullable = false)
	private Integer id;
	
	@Column(name = "horas")
	private Integer horas;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "mes")
	private Date mes;

}
