package com.fintbank.app.Service;

import org.springframework.stereotype.Service;

import com.fintbank.app.Commons.CommonServiceImple;
import com.fintbank.app.Entity.Role;
import com.fintbank.app.Repository.RoleRepository;

@Service
public class RoleServiceImple extends CommonServiceImple<Role, RoleRepository> implements RoleService {

}
