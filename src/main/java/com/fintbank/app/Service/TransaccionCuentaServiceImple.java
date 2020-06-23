package com.fintbank.app.Service;

import org.springframework.stereotype.Service;

import com.fintbank.app.Commons.CommonServiceImple;
import com.fintbank.app.Entity.TransaccionCuenta;
import com.fintbank.app.Repository.TransaccionCuentaRepository;

@Service
public class TransaccionCuentaServiceImple extends CommonServiceImple<TransaccionCuenta, TransaccionCuentaRepository> implements TransaccionCuentaService {

}
