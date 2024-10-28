package com.Sena.ShoppingCart.IRepository.ISecurityRepository;

import com.Sena.ShoppingCart.Entity.Security.Module;
import com.Sena.ShoppingCart.IRepository.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IModuleRepository extends IBaseRepository<Module, Long>{

}
