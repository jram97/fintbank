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
@Table(name = "transaccioncuenta", catalog = "postgres", schema = "public")
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

	@JoinColumn(name = "usuario_de_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuariode;

	@JoinColumn(name = "usuario_para_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuariopara;

	@JoinColumn(name = "tipotransaccion_envio_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private TipoTransaccion tipotransaccionenvio;

	@JoinColumn(name = "tipotransaccion_recibo_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private TipoTransaccion tipotransaccionrecibo;

	@JoinColumn(name = "cuenta_envia_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Cuenta cuentaenvia;

	@JoinColumn(name = "cuenta_recibe_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Cuenta cuentarecibe;

	/*
	 * @JsonIgnoreProperties(value = { "transaccioncuentaList" })
	 * 
	 * @JoinColumn(name = "transaccion_id")
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY) private Transaccion transaccion;
	 */

	@PrePersist
	public void prePersist() {
		this.aplicado = new Date();
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

	public Usuario getUsuariode() {
		return usuariode;
	}

	public void setUsuariode(Usuario usuario_de) {
		this.usuariode = usuario_de;
	}

	public Usuario getUsuariopara() {
		return usuariopara;
	}

	public void setUsuario_para(Usuario usuario_para) {
		this.usuariopara = usuario_para;
	}

	public TipoTransaccion getTipotransaccionenvio() {
		return tipotransaccionenvio;
	}

	public void setTipotransaccionenvio(TipoTransaccion tipotransaccionenvio) {
		this.tipotransaccionenvio = tipotransaccionenvio;
	}

	public TipoTransaccion getTipotransaccionrecibo() {
		return tipotransaccionrecibo;
	}

	public void setTipotransaccionrecibo(TipoTransaccion tipotransaccionrecibo) {
		this.tipotransaccionrecibo = tipotransaccionrecibo;
	}

	public void setUsuariopara(Usuario usuariopara) {
		this.usuariopara = usuariopara;
	}

	/*
	 * public Transaccion getTransaccion() { return transaccion; }
	 * 
	 * public void setTransaccion(Transaccion transaccion) { this.transaccion =
	 * transaccion; }
	 */

	public Cuenta getCuentaenvia() {
		return cuentaenvia;
	}

	public void setCuentaenvia(Cuenta cuentaenvia) {
		this.cuentaenvia = cuentaenvia;
	}

	public Cuenta getCuentarecibe() {
		return cuentarecibe;
	}

	public void setCuentarecibe(Cuenta cuentarecibe) {
		this.cuentarecibe = cuentarecibe;
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