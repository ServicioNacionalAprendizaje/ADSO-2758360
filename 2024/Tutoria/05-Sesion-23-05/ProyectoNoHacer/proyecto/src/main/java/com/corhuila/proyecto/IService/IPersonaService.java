package com.corhuila.proyecto.IService;

import com.corhuila.proyecto.Entity.Carro;
import com.corhuila.proyecto.Entity.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    Persona save(Persona persona);
    void update(Persona persona, Long id);
    void delete(Long id);
    Optional<Persona> findById(Long id);
    List<Persona> findAll();
}
