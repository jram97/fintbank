package com.fintbank.app.Entity.DTO;

public class Register {

	private String direccion;

	private String alias;

	private String notificacion;

	private String clave;

	private String verificacion;

	private String tipoautenticacion;

	private String autenticacionclave;

	private Long roleId;

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

	public String getTipoautenticacion() {
		return tipoautenticacion;
	}

	public void setTipoautenticacion(String tipoautenticacion) {
		this.tipoautenticacion = tipoautenticacion;
	}

	public String getAutenticacionclave() {
		return autenticacionclave;
	}

	public void setAutenticacionclave(String autenticacionclave) {
		this.autenticacionclave = autenticacionclave;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
