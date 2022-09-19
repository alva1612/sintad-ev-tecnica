package com.reto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Table(name = "tb_tipo_documento")
@Data
public class TipoDocumento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_documento")
	private int id;
	private String codigo;
	private String nombre;
	private String descripcion;
	@Type(type="org.hibernate.type.BooleanType")
	private boolean estado;
}
