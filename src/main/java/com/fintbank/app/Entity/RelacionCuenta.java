package com.fintbank.app.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 *
 * @author Javier Ramirez
 */
@Entity
@Table(name = "relacioncuenta", catalog = "postgres", schema = "public")
public class RelacionCuenta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;

	@JoinColumn(name = "cuenta_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Cuenta cuenta;

	private String tipovinculo = "T";

	private Date fechatransaccion;

	@PrePersist
	public void prePersist() {
		this.fechatransaccion = new Date();
	}

	public RelacionCuenta() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public String getTipovinculo() {
		return tipovinculo;
	}

	public void setTipovinculo(String tipovinculo) {
		this.tipovinculo = tipovinculo;
	}

	public Date getFechatransaccion() {
		return fechatransaccion;
	}

	public void setFechatransaccion(Date fechatransaccion) {
		this.fechatransaccion = fechatransaccion;
	}
}