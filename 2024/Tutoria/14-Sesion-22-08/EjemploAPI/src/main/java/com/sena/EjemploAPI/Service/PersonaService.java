package com.sena.EjemploAPI.Service;

import com.sena.EjemploAPI.Entity.Persona;
import com.sena.EjemploAPI.IRepository.IPersonaRepository;
import com.sena.EjemploAPI.IService.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private IPersonaRepository repository;

    @Override
    public List<Persona> All() {
        return repository.findAll();
    }

    @Override
    public Optional<Persona> FindById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Persona Save(Persona persona) {
        return repository.save(persona);
    }

    @Override
    public void Update(Persona persona, Long id) {
        //Verificar si existe
        Optional<Persona> op = repository.findById(id);

        //Verficar si el objeto op esta lleno o vacio.
        if(op.isEmpty()){
            System.out.print("Registro no existe.");
        }else {
            Persona updatePersona = op.get();
            updatePersona.setNombre(persona.getNombre());
            updatePersona.setCorreo(persona.getCorreo());
            updatePersona.setCelular(persona.getCelular());
            updatePersona.setDireccion(persona.getDireccion());

            repository.save(updatePersona);
        }
    }

    @Override
    public void Datele(Long id) {
        repository.deleteById(id);
    }
}
