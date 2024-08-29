package com.sena.EjemploAPI.IService;

import com.sena.EjemploAPI.Entity.Persona;
import com.sena.EjemploAPI.Entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    //Retorna la lista de todos los datos de la entidad
    List<Usuario> All();

    //Retorna el registro de la entidad por ID
    Optional<Usuario> FindById(Long id);

    //Guardar un registro en la entidad
    Usuario Save(Usuario usuario);

    //Modificar un registro de la entidad
    void  Update(Usuario usuario, Long id);

    //Eliminar un registro de la entidad
    void Datele(Long id);
}
