package com.sena.EjemploAPI.IService;

import com.sena.EjemploAPI.Entity.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {

    //Retorna la lista de todos los datos de la entidad
    List<Persona> All();

    //Retorna el registro de la entidad por ID
    Optional<Persona> FindById(Long id);

    //Guardar un registro en la entidad
    Persona Save(Persona persona);

    //Modificar un registro de la entidad
    void  Update(Persona persona, Long id);

    //Eliminar un registro de la entidad
    void Datele(Long id);
}
