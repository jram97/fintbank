package com.fintbank.app.Entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Javier Ramirez
 */
@Entity
@Table(name = "controlcuenta", catalog = "postgres", schema = "public")
public class ControlCuenta implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name = "entrada")
	private BigDecimal entrada = new BigDecimal("0.00");

	@Column(name = "salida")
	private BigDecimal salida = new BigDecimal("0.00");

	@JoinColumn(name = "cuenta_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Cuenta cuenta;

	@JsonIgnoreProperties(value = { "controlcuentaList" })
	@JoinColumn(name = "regla_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private ReglaDefinicion regladefinicion;

	@PrePersist
	public void prePersist() {
		this.fecha = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getEntrada() {
		return entrada;
	}

	public void setEntrada(BigDecimal entrada) {
		this.entrada = entrada;
	}

	public BigDecimal getSalida() {
		return salida;
	}

	public void setSalida(BigDecimal salida) {
		this.salida = salida;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public ReglaDefinicion getRegladefinicion() {
		return regladefinicion;
	}

	public void setRegladefinicion(ReglaDefinicion regladefinicion) {
		this.regladefinicion = regladefinicion;
	}
}