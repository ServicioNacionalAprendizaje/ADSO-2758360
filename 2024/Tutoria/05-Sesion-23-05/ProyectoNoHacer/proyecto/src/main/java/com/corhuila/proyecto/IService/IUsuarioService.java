package com.corhuila.proyecto.IService;

import com.corhuila.proyecto.Entity.Persona;
import com.corhuila.proyecto.Entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    Usuario save(Usuario usuario);
    void update(Usuario usuario, Long id);
    void delete(Long id);
    Optional<Usuario> findById(Long id);
    List<Usuario> findAll();
}
