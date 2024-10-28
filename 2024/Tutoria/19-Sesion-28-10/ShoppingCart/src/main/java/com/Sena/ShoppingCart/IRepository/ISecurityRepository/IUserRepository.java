package com.Sena.ShoppingCart.IRepository.ISecurityRepository;

import com.Sena.ShoppingCart.Entity.Security.User;
import com.Sena.ShoppingCart.IRepository.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends IBaseRepository<User, Long> {
}
