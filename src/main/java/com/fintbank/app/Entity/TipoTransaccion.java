package com.fintbank.app.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Javier Ramirez
 */
@Entity
@Table(name = "tipotransaccion", catalog = "postgres", schema = "public")
public class TipoTransaccion implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "codigo")
	private String codigo;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "fisica")
	private String fisica = "N";

	@Column(name = "efectocontable")
	private Short efectocontable = 1;

	@Column(name = "efectosaldo")
	private Short efectosaldo = 1;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getFisica() {
		return fisica;
	}

	public void setFisica(String fisica) {
		this.fisica = fisica;
	}

	public Short getEfectocontable() {
		return efectocontable;
	}

	public void setEfectocontable(Short efectocontable) {
		this.efectocontable = efectocontable;
	}

	public Short getEfectosaldo() {
		return efectosaldo;
	}

	public void setEfectosaldo(Short efectosaldo) {
		this.efectosaldo = efectosaldo;
	}
}