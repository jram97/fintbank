package com.fintbank.app.Config;

import java.util.Calendar;
import java.util.Date;

public class Functions {

	public static Date sumarRestarDias(Date fecha, int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, dias);
		return calendar.getTime();
	}
	
	public static String numeroCuenta(String nombre, String nIndentidad) {
		String posible = nombre + nIndentidad + nIndentidad + nIndentidad;
		String cuenta = "";
		for (int i = 0; i < 8; i++) {
			cuenta += posible.charAt((int) Math.floor(Math.random() * posible.length()));
		}
		return cuenta;
	}
}
