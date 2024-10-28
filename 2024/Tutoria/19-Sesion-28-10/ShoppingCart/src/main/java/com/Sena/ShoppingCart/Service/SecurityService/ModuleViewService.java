package com.Sena.ShoppingCart.Service.SecurityService;

import com.Sena.ShoppingCart.Entity.Security.Module;
import com.Sena.ShoppingCart.Entity.Security.ModuleView;
import com.Sena.ShoppingCart.IRepository.IBaseRepository;
import com.Sena.ShoppingCart.IRepository.ISecurityRepository.IModuleViewRepository;
import com.Sena.ShoppingCart.IService.ISecurityService.IModuleService;
import com.Sena.ShoppingCart.IService.ISecurityService.IModuleViewService;
import com.Sena.ShoppingCart.Service.ABaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ModuleViewService extends ABaseService<ModuleView> implements IModuleViewService  {

    @Autowired
    private IModuleViewRepository repository;

    @Override
    protected IBaseRepository<ModuleView, Long> getRepository() {
        return repository;
    }
}
