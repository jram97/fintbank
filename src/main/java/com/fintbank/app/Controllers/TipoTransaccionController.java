package com.fintbank.app.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fintbank.app.Commons.CommonController;
import com.fintbank.app.Entity.TipoTransaccion;
import com.fintbank.app.Service.TipoTransaccionService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/v1/tipo-transaccion")
public class TipoTransaccionController extends CommonController<TipoTransaccion, TipoTransaccionService> {

}
