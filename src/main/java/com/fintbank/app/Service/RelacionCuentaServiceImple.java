package com.fintbank.app.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fintbank.app.Commons.CommonServiceImple;
import com.fintbank.app.Entity.Cuenta;
import com.fintbank.app.Entity.RelacionCuenta;
import com.fintbank.app.Entity.Usuario;
import com.fintbank.app.Repository.RelacionCuentaRepository;

@Service
public class RelacionCuentaServiceImple extends CommonServiceImple<RelacionCuenta, RelacionCuentaRepository>
		implements RelacionCuentaService {

	@Transactional(readOnly = true, timeout = 10)
	@Override
	public Usuario buscarUsuarioPorId(Long id) {
		return repository.buscarUsuarioPorId(id);
	}

	@Transactional(readOnly = true, timeout = 10)
	@Override
	public RelacionCuenta findByCuenta(Cuenta cuenta) {
		return repository.findByCuenta(cuenta);
	}

	@Transactional(readOnly = true, timeout = 10)
	@Override
	public RelacionCuenta buscarPorUsuarioId(Long id) {
		return repository.buscarPorUsuarioId(id);
	}
}