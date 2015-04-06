package com.hitss.swf.hco.model.catalogo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "COLABORADOR")
public class Colaborador implements Serializable {

	/**
	 * Serial Version UID de la clase
	 */
	private static final long serialVersionUID = 4375706125841665849L;

	public Colaborador() {
		super();
	}

	public Colaborador(int idGerente) {
		this.id = idGerente;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COLABORADOR", updatable = false, nullable = false)
	private Integer id;

	@Column(length = 6, name = "NUMERO_EMPLEADO")
	private String numeroEmpleado;

	@Column(length = 50, name = "NOMBRE")
	private String nombre;

	@Column(length = 50, name = "APELLIDO_PATERNO")
	private String apellidoPaterno;

	@Column(length = 50, name = "APELLIDO_MATERNO")
	private String apellidoMaterno;

	@Column(length = 4, name = "CLAVE_INICIALES")
	private String claveIniciales;

	@Column(name = "COSTO_BASE_MENSUAL")
	private BigDecimal costoBaseMensual;

	@Column(name = "COSTO_BASE")
	private BigDecimal costoBase;

	@Column(name = "FECHA_INGRESO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaIngreso;

	@Column(name = "FECHA_ULTIMA_MODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaUltimaModificacion;

	@Column(name = "ESTADO")
	private Boolean estado;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ROL_EMPLEADO")
	private RolEmpleado rol;

	@JoinTable(name = "JERARQUIA_COLABORADOR", 
				joinColumns = { @JoinColumn(name = "ID_SUPERIOR", referencedColumnName = "ID_COLABORADOR", nullable = false) }, 
				inverseJoinColumns = { @JoinColumn(name = "ID_SUBORDINADOR", referencedColumnName = "ID_COLABORADOR", nullable = false) })
	@ManyToMany(fetch = FetchType.LAZY)
	private Collection<Colaborador> subordinados;
	
	@ManyToMany(mappedBy = "subordinados", fetch = FetchType.LAZY)
    private Collection<Colaborador> superiores;

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
		if (!(obj instanceof Colaborador)) {
			return false;
		}
		Colaborador other = (Colaborador) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(String numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMatero) {
		this.apellidoMaterno = apellidoMatero;
	}

	public String getClaveIniciales() {
		return claveIniciales;
	}

	public void setClaveIniciales(String claveIniciales) {
		this.claveIniciales = claveIniciales;
	}

	public BigDecimal getCostoBaseMensual() {
		return costoBaseMensual;
	}

	public void setCostoBaseMensual(BigDecimal costoBAseMensual) {
		this.costoBaseMensual = costoBAseMensual;
	}

	public BigDecimal getCostoBase() {
		return costoBase;
	}

	public void setCostoBase(BigDecimal costoBase) {
		this.costoBase = costoBase;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaImngreso) {
		this.fechaIngreso = fechaImngreso;
	}

	public Date getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (numeroEmpleado != null && !numeroEmpleado.trim().isEmpty())
			result += "numeroEmpleado: " + numeroEmpleado;
		if (nombre != null && !nombre.trim().isEmpty())
			result += ", nombre: " + nombre;
		if (apellidoPaterno != null && !apellidoPaterno.trim().isEmpty())
			result += ", apellidoPaterno: " + apellidoPaterno;
		if (apellidoMaterno != null && !apellidoMaterno.trim().isEmpty())
			result += ", apellidoMaterno: " + apellidoMaterno;
		if (claveIniciales != null && !claveIniciales.trim().isEmpty())
			result += ", claveIniciales: " + claveIniciales;
		if (costoBaseMensual != null)
			result += ", costoBaseMensual: " + costoBaseMensual;
		if (costoBase != null)
			result += ", costoBase: " + costoBase;
		if (estado != null)
			result += ", estado: " + estado;
		return result;
	}

	public RolEmpleado getRol() {
		return rol;
	}

	public void setRol(RolEmpleado rol) {
		this.rol = rol;
	}

	public Collection<Colaborador> getSubordinados() {
		return subordinados;
	}

	public void setSubordinados(Collection<Colaborador> subordinados) {
		this.subordinados = subordinados;
	}

	public Collection<Colaborador> getSuperiores() {
		return superiores;
	}

	public void setSuperiores(Collection<Colaborador> superiores) {
		this.superiores = superiores;
	}

}