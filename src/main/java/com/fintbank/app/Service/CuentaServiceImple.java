package com.fintbank.app.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fintbank.app.Commons.CommonServiceImple;
import com.fintbank.app.Entity.Cuenta;
import com.fintbank.app.Repository.CuentaRepository;

@Service
public class CuentaServiceImple extends CommonServiceImple<Cuenta, CuentaRepository> implements CuentaService {

	@Transactional(readOnly = true, timeout = 10)
	@Override
	public Optional<Cuenta> findByNumero(String numero) {
		return repository.findByNumero(numero);
	}
	
}
