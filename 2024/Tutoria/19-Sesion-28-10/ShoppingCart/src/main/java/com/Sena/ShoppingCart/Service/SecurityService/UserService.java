package com.Sena.ShoppingCart.Service.SecurityService;

import com.Sena.ShoppingCart.Entity.Security.Module;
import com.Sena.ShoppingCart.Entity.Security.User;
import com.Sena.ShoppingCart.IRepository.IBaseRepository;
import com.Sena.ShoppingCart.IRepository.ISecurityRepository.IUserRepository;
import com.Sena.ShoppingCart.IService.IBaseService;
import com.Sena.ShoppingCart.IService.ISecurityService.IUserService;
import com.Sena.ShoppingCart.Service.ABaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ABaseService<User> implements IUserService {

    @Override
    protected IBaseRepository<User, Long> getRepository() {
        return repository;
    }

    @Autowired
    private IUserRepository repository;
}
