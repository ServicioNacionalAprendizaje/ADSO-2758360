package com.Sena.ShoppingCart.IRepository.ISecurityRepository;

import com.Sena.ShoppingCart.Entity.Security.User;
import com.Sena.ShoppingCart.IRepository.IBaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends IBaseRepository<User, Long> {
    @Query(value = "SELECT " +
            "   u.username ," +
            "   u.password " +
            "   FROM user u ", nativeQuery = true)
    Optional<User> Login(@Param("user") String user, @Param("pwd") String pwd);
}
