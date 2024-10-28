package com.Sena.ShoppingCart.IRepository.ISecurityRepository;

import com.Sena.ShoppingCart.Entity.Security.Person;
import com.Sena.ShoppingCart.IRepository.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends IBaseRepository<Person, Long> {
}
