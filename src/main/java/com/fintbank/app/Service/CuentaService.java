package com.fintbank.app.Service;

import java.util.Optional;

import com.fintbank.app.Commons.CommonService;
import com.fintbank.app.Entity.Cuenta;

public interface CuentaService extends CommonService<Cuenta> {

	public Optional<Cuenta> findByNumero(String numero);
	
}
