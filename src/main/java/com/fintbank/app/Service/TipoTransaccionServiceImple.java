package com.fintbank.app.Service;

import org.springframework.stereotype.Service;

import com.fintbank.app.Commons.CommonServiceImple;
import com.fintbank.app.Entity.TipoTransaccion;
import com.fintbank.app.Repository.TipoTransaccionRepository;

@Service
public class TipoTransaccionServiceImple extends CommonServiceImple<TipoTransaccion, TipoTransaccionRepository> implements TipoTransaccionService {

}
