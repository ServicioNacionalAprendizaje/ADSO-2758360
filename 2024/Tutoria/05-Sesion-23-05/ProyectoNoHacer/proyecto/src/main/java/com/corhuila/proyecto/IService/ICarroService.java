package com.corhuila.proyecto.IService;

import com.corhuila.proyecto.Entity.Carro;

import java.util.List;
import java.util.Optional;

public interface ICarroService {
    Carro save(Carro carro);
    void update(Carro carro, Long id);
    void delete(Long id);
    Optional<Carro> findById(Long id);
    List<Carro> findAll();
}
