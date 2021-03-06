package com.fintbank.app.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Javier Ramirez
 */
@Entity
@Table(name = "cuenta", catalog = "postgres", schema = "public")
public class Cuenta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "numero")
	private String numero;

	@Column(name = "estado")
	private Short estado = 1;

	@Column(name = "saldo")
	private double saldo = 0.00;

	@Column(name = "correlativo")
	private int correlativooperaciones = 0;

	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@JoinColumn(name = "tipo_cuenta_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private DefinicionCuenta definicion;
	
	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" }, allowSetters = true)
	@JoinColumn(name = "regla_definicion_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private ReglaDefinicion reglaDefinicion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Short getEstado() {
		return estado;
	}

	public void setEstado(Short estado) {
		this.estado = estado;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getCorrelativooperaciones() {
		return correlativooperaciones;
	}

	public void setCorrelativooperaciones(int correlativooperaciones) {
		this.correlativooperaciones = correlativooperaciones;
	}

	public DefinicionCuenta getDefinicion() {
		return definicion;
	}

	public void setDefinicion(DefinicionCuenta definicion) {
		this.definicion = definicion;
	}

	public ReglaDefinicion getReglaDefinicion() {
		return reglaDefinicion;
	}

	public void setReglaDefinicion(ReglaDefinicion reglaDefinicion) {
		this.reglaDefinicion = reglaDefinicion;
	}
}