package com.Sena.ShoppingCart.Service.SecurityService;

import com.Sena.ShoppingCart.Entity.Security.Role;
import com.Sena.ShoppingCart.IRepository.IBaseRepository;
import com.Sena.ShoppingCart.IRepository.ISecurityRepository.IRoleRepository;
import com.Sena.ShoppingCart.IService.ISecurityService.IRoleService;
import com.Sena.ShoppingCart.Service.ABaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends ABaseService<Role> implements IRoleService {

    @Autowired
    private IRoleRepository repository;

    @Override
    protected IBaseRepository<Role, Long> getRepository() {
        return repository;
    }
}
