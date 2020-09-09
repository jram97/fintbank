package com.fintbank.app.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fintbank.app.Commons.CommonController;
import com.fintbank.app.Entity.Usuario;
import com.fintbank.app.Service.UsuarioService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController extends CommonController<Usuario, UsuarioService> {

}
