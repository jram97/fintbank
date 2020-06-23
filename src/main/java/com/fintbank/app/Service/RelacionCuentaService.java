package com.fintbank.app.Service;

import com.fintbank.app.Commons.CommonService;
import com.fintbank.app.Entity.Cuenta;
import com.fintbank.app.Entity.RelacionCuenta;
import com.fintbank.app.Entity.Usuario;

public interface RelacionCuentaService extends CommonService<RelacionCuenta> {

	public Usuario buscarUsuarioPorId(Long id);
	
	public RelacionCuenta buscarPorUsuarioId(Long id);
	
	public RelacionCuenta findByCuenta(Cuenta cuenta);
	
}
