package com.reto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Table(name = "tb_entidad")
@Entity
public class Entidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_entidad")
	private int id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento")
	private TipoDocumento tipoDocumento;
	@Column(name = "nro_documento")
	private String numdocumento;
	@Column(name = "razon_social")
	private String razonSocial;
	@Column(name = "nombre_comercial")
	private String nomComercial;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_tipo_contribuyente", referencedColumnName = "id_tipo_contribuyente")
	private TipoContribuyente tipoContribuyente;
	private String direccion;
	private String telefono;
	@Type(type="org.hibernate.type.BooleanType")
	private boolean estado;
}
