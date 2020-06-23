package com.fintbank.app.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fintbank.app.Commons.CommonController;
import com.fintbank.app.Entity.Role;
import com.fintbank.app.Service.RoleService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("ws/role")
public class RoleController extends CommonController<Role, RoleService> {

}
