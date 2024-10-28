package com.Sena.ShoppingCart.Service.SecurityService;

import com.Sena.ShoppingCart.Entity.Security.Module;
import com.Sena.ShoppingCart.IRepository.IBaseRepository;
import com.Sena.ShoppingCart.IRepository.ISecurityRepository.IModuleRepository;
import com.Sena.ShoppingCart.IService.ISecurityService.IModuleService;
import com.Sena.ShoppingCart.Service.ABaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleService extends ABaseService<Module> implements IModuleService  {
    @Override
    protected IBaseRepository<Module, Long> getRepository() {
        return repository;
    }
    @Autowired
    private IModuleRepository repository;
}
