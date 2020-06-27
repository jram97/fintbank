package com.fintbank.app.Entity.DTO;

public class TransaccionDTO {

	private String para;

	private Long tipoEnvio;

	private Long tipoRecibo;

	private double monto;

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public Long getTipoEnvio() {
		return tipoEnvio;
	}

	public void setTipoEnvio(Long tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}

	public Long getTipoRecibo() {
		return tipoRecibo;
	}

	public void setTipoRecibo(Long tipoRecibo) {
		this.tipoRecibo = tipoRecibo;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

}
