package com.Sena.ShoppingCart.IRepository.ISecurityRepository;

import com.Sena.ShoppingCart.Entity.Security.ModuleView;
import com.Sena.ShoppingCart.IRepository.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IModuleViewRepository extends IBaseRepository<ModuleView, Long> {
}
