package com.hitss.swf.hco.model.catalogo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROL_EMPLEADO")
public class RolEmpleado extends Catalogo {
	
	private static final long serialVersionUID = 5136046335471019344L;

	public static final RolEmpleado DIRECTOR = new RolEmpleado(1);
	
	public static final RolEmpleado GERENTE = new RolEmpleado(2);
	
	public static final RolEmpleado COORDINADOR = new RolEmpleado(3);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROL_EMPLEADO", updatable = false, nullable = false)
	private Integer id;
	
	public RolEmpleado() {
		super();
	}

	public RolEmpleado(int id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RolEmpleado) {
			RolEmpleado rol = (RolEmpleado) obj;
			return this.id == rol.id;
		}
		return false;
	}

}
