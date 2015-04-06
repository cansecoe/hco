package com.hitss.swf.hco.model.catalogo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FABRICA")
public class Fabrica extends Catalogo {

	private static final long serialVersionUID = -2616932537378599886L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_FABRICA", updatable = false, nullable = false)
	private Integer id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_GERENTE")
	private Colaborador gerente;
	
	public Fabrica() {
		super();
	}

	public Fabrica(Integer idFabrica) {
		this.id = idFabrica;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Colaborador getGerente() {
		return gerente;
	}

	public void setGerente(Colaborador gerente) {
		this.gerente = gerente;
	}

}
