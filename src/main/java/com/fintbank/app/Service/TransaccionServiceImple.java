package com.fintbank.app.Service;

import org.springframework.stereotype.Service;

import com.fintbank.app.Commons.CommonServiceImple;
import com.fintbank.app.Entity.Transaccion;
import com.fintbank.app.Repository.TransaccionRepository;

@Service
public class TransaccionServiceImple extends CommonServiceImple<Transaccion, TransaccionRepository> implements TransaccionService {

}
