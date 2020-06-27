package com.fintbank.app.Entity.DTO;

public class Register {

	private String direccion;

	private String alias;

	private String notificacion;

	private String clave;

	private String verificacion;

	private String tipoAutenticacion;

	private String autenticacionClave;
	
	private String numeroIdentificacion;

	private Long role;

	private Long tipoDefinicion;
	
	private Long cuenta;

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(String notificacion) {
		this.notificacion = notificacion;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getVerificacion() {
		return verificacion;
	}

	public void setVerificacion(String verificacion) {
		this.verificacion = verificacion;
	}

	public String getTipoAutenticacion() {
		return tipoAutenticacion;
	}

	public void setTipoAutenticacion(String tipoAutenticacion) {
		this.tipoAutenticacion = tipoAutenticacion;
	}

	public String getAutenticacionClave() {
		return autenticacionClave;
	}

	public void setAutenticacionClave(String autenticacionClave) {
		this.autenticacionClave = autenticacionClave;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public Long getRole() {
		return role;
	}

	public void setRole(Long role) {
		this.role = role;
	}

	public Long getTipoDefinicion() {
		return tipoDefinicion;
	}

	public void setTipoDefinicion(Long tipoDefinicion) {
		this.tipoDefinicion = tipoDefinicion;
	}

	public Long getCuenta() {
		return cuenta;
	}

	public void setCuenta(Long cuenta) {
		this.cuenta = cuenta;
	}
}
