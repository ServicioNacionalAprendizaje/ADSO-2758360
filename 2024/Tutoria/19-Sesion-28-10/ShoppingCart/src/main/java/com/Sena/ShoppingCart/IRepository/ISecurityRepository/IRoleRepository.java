package com.Sena.ShoppingCart.IRepository.ISecurityRepository;

import com.Sena.ShoppingCart.Entity.Security.Role;
import com.Sena.ShoppingCart.IRepository.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends IBaseRepository<Role, Long> {
}
