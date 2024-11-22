package com.Corhuila.Parque.IRepository;

import com.Corhuila.Parque.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = "SELECT * FROM cliente WHERE documento = :documento ",nativeQuery = true)
    Optional<Cliente> findByDocument(String documento);
}
