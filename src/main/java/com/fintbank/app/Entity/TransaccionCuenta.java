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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Javier Ramirez
 */
@Entity
@Table(name = "transacciones", catalog = "postgres", schema = "public")
public class TransaccionCuenta implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "referencia")
	private String referencia;

	@Column(name = "monto")
	private double monto = 0.00;

	@Column(name = "estado")
	private Short estado;

	@Column(name = "aplicado")
	@Temporal(TemporalType.TIMESTAMP)
	private Date aplicado;

	@Column(name = "contabilizado")
	@Temporal(TemporalType.TIMESTAMP)
	private Date contabilizado;

	@JoinColumn(name = "tipotransaccion_envio_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private TipoTransaccion tipoEnvia;

	@JoinColumn(name = "tipotransaccion_recibo_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private TipoTransaccion tipoRecibe;

	@JoinColumn(name = "cuenta_envia_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Cuenta envia;

	@JoinColumn(name = "cuenta_recibe_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Cuenta recibe;

	@PrePersist
	public void prePersist() {
		this.contabilizado = new Date();
	}

	public TransaccionCuenta() {
	}

	public TransaccionCuenta(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Short getEstado() {
		return estado;
	}

	public void setEstado(Short estado) {
		this.estado = estado;
	}

	public Date getAplicado() {
		return aplicado;
	}

	public void setAplicado(Date aplicado) {
		this.aplicado = aplicado;
	}

	public Date getContabilizado() {
		return contabilizado;
	}

	public void setContabilizado(Date contabilizado) {
		this.contabilizado = contabilizado;
	}

	public TipoTransaccion getTipoEnvia() {
		return tipoEnvia;
	}

	public void setTipoEnvio(TipoTransaccion tipoEnvia) {
		this.tipoEnvia = tipoEnvia;
	}

	public TipoTransaccion getTipoRecibe() {
		return tipoRecibe;
	}

	public void setTipoRecibe(TipoTransaccion tipoRecibe) {
		this.tipoRecibe = tipoRecibe;
	}

	public Cuenta getEnvia() {
		return envia;
	}

	public void setEnvia(Cuenta envia) {
		this.envia = envia;
	}

	public Cuenta getRecibe() {
		return recibe;
	}

	public void setRecibe(Cuenta recibe) {
		this.recibe = recibe;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TransaccionCuenta)) {
			return false;
		}
		TransaccionCuenta tc = (TransaccionCuenta) obj;
		return this.id != null && this.id.equals(tc.getId());
	}
}