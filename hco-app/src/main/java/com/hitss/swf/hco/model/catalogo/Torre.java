package com.hitss.swf.hco.model.catalogo;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TORRE")
public class Torre extends Catalogo {

	private static final long serialVersionUID = 3047631834388986758L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TORRE", updatable = false, nullable = false)
	private Integer id;
	
	@JoinTable(name = "TORRE_DIVISION", 
			joinColumns = { @JoinColumn(name = "ID_TORRE", referencedColumnName = "ID_TORRE")},
			inverseJoinColumns = { @JoinColumn(name = "ID_DIVISION", referencedColumnName = "ID_DIVISION", nullable = false) })
	@ManyToMany(fetch = FetchType.LAZY)
	private Collection<Division> divisiones;
	
	@JoinTable(name = "TORRE_AREA_CONOCIMIENTO", 
			joinColumns = { @JoinColumn(name = "ID_TORRE", referencedColumnName = "ID_TORRE")},
			inverseJoinColumns = { @JoinColumn(name = "ID_AREA_CONOCIMIENTO", referencedColumnName = "ID_AREA_CONOCIMIENTO", nullable = false) })
	@ManyToMany(fetch = FetchType.LAZY)
	private Collection<AreaConocimiento> areasConocimiento;
	
	@JoinTable(name = "TORRE_COLABORADOR", 
			joinColumns = { @JoinColumn(name = "ID_TORRE", referencedColumnName = "ID_TORRE")},
			inverseJoinColumns = { @JoinColumn(name = "ID_COLABORADOR", referencedColumnName = "ID_COLABORADOR", nullable = false) })
	@ManyToMany(fetch = FetchType.LAZY)
	private Collection<Colaborador> colaboradores;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_FABRICA")
	private Fabrica fabrica;
	
	public Torre() {
		super();
	}

	public Torre(Integer idTorre) {
		this.id = idTorre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Collection<Division> getDivisiones() {
		return divisiones;
	}

	public void setDivisiones(Collection<Division> divisiones) {
		this.divisiones = divisiones;
	}

	public Fabrica getFabrica() {
		return fabrica;
	}

	public void setFabrica(Fabrica fabrica) {
		this.fabrica = fabrica;
	}

}
