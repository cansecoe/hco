package com.hitss.swf.hco.model.catalogo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APLICACION")
public class Aplicacion implements Serializable
{

   /**
    * Serial Version UID
    */
   private static final long serialVersionUID = 9092846143441298742L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ID_APLICACION", updatable = false, nullable = false)
   private Integer id;

   @Column(length = 5, name = "CODIGO", nullable = false)
   private String codigo;

   @Column(length = 50, name = "NOMBRE", nullable = false)
   private String nombre;

   public Integer getId()
   {
      return this.id;
   }

   public void setId(final Integer id)
   {
      this.id = id;
   }
   
   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
      {
         return true;
      }
      if (!(obj instanceof Aplicacion))
      {
         return false;
      }
      Aplicacion other = (Aplicacion) obj;
      if (id != null)
      {
         if (!id.equals(other.id))
         {
            return false;
         }
      }
      return true;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      return result;
   }

   public String getCodigo()
   {
      return codigo;
   }

   public void setCodigo(String codigo)
   {
      this.codigo = codigo;
   }

   public String getNombre()
   {
      return nombre;
   }

   public void setNombre(String nombre)
   {
      this.nombre = nombre;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (codigo != null && !codigo.trim().isEmpty())
         result += "codigo: " + codigo;
      if (nombre != null && !nombre.trim().isEmpty())
         result += ", nombre: " + nombre;
      return result;
   }
}