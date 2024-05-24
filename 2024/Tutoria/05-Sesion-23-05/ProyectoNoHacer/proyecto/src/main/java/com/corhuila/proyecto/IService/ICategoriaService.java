package com.corhuila.proyecto.IService;

import com.corhuila.proyecto.Entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {
    Categoria save(Categoria categoria);
    void update(Categoria categoria, Long id);
    void delete(Long id);
    Optional<Categoria> findById(Long id);
    List<Categoria> findAll();
}
