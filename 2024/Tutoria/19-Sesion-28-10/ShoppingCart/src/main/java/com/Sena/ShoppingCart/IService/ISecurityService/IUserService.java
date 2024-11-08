package com.Sena.ShoppingCart.IService.ISecurityService;

import com.Sena.ShoppingCart.Entity.Security.User;
import com.Sena.ShoppingCart.IService.IBaseService;

import java.util.Optional;

public interface IUserService extends IBaseService<User> {
    Optional<User> Login(String username, String password);
}
