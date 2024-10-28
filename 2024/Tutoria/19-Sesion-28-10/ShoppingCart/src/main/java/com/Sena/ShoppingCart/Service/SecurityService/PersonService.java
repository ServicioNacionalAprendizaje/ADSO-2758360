package com.Sena.ShoppingCart.Service.SecurityService;

import com.Sena.ShoppingCart.Entity.Security.Module;
import com.Sena.ShoppingCart.Entity.Security.Person;
import com.Sena.ShoppingCart.IRepository.IBaseRepository;
import com.Sena.ShoppingCart.IRepository.ISecurityRepository.IModuleRepository;
import com.Sena.ShoppingCart.IRepository.ISecurityRepository.IPersonRepository;
import com.Sena.ShoppingCart.IService.IBaseService;
import com.Sena.ShoppingCart.IService.ISecurityService.IPersonService;
import com.Sena.ShoppingCart.Service.ABaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends ABaseService<Person> implements IPersonService {

    @Autowired
    private IPersonRepository repository;

    @Override
    protected IBaseRepository<Person, Long> getRepository() {
        return repository;
    }
}
