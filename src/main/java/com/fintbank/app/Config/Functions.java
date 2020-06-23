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

}