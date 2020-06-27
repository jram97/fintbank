package com.fintbank.app.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Javier Ramirez
 */
@Entity
@Table(name = "regladefinicion", catalog = "postgres", schema = "public")
public class ReglaDefinicion implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "origen")
	private int origen;

	@Column(name = "maximo_diario")
	private int maximodiario;

	@Column(name = "maximo_operacion")
	private int maximooperacion;

	@JsonIgnoreProperties(value = { "regladefinicionList" })
	@JoinColumn(name = "definicion_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private DefinicionCuenta definicioncuenta;

	@JoinColumn(name = "transaccion_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private TipoTransaccion tipotransaccion;

	@JsonIgnoreProperties(value = { "regladefinicion" }, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ControlCuenta> controlcuentaList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getOrigen() {
		return origen;
	}

	public void setOrigen(int origen) {
		this.origen = origen;
	}

	public int getMaximodiario() {
		return maximodiario;
	}

	public void setMaximodiario(int maximodiario) {
		this.maximodiario = maximodiario;
	}

	public int getMaximooperacion() {
		return maximooperacion;
	}

	public void setMaximooperacion(int maximooperacion) {
		this.maximooperacion = maximooperacion;
	}

	public DefinicionCuenta getDefinicioncuenta() {
		return definicioncuenta;
	}

	public void setDefinicioncuenta(DefinicionCuenta definicioncuenta) {
		this.definicioncuenta = definicioncuenta;
	}

	public TipoTransaccion getTipotransaccion() {
		return tipotransaccion;
	}

	public void setTipotransaccion(TipoTransaccion tipotransaccion) {
		this.tipotransaccion = tipotransaccion;
	}

	public List<ControlCuenta> getControlcuentaList() {
		return controlcuentaList;
	}

	public void setControlcuentaList(List<ControlCuenta> controlcuentaList) {
		this.controlcuentaList = controlcuentaList;
	}
}
