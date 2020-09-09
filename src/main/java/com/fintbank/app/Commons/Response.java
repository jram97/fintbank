package com.fintbank.app.Commons;

public class Response {

	private int code;
	private String mensaje;
	private String error;

	public Response(int code, String mensaje) {
		this.code = code;
		this.mensaje = mensaje;
	}
	
	public Response(int code, String mensaje, String error) {
		this.code = code;
		this.mensaje = mensaje;
		this.error = error;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
