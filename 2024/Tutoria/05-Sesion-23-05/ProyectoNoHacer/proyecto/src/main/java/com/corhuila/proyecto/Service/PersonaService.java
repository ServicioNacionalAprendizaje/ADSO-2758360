package com.corhuila.proyecto.Service;

import com.corhuila.proyecto.Entity.Persona;
import com.corhuila.proyecto.IRepository.IPersonaRepository;
import com.corhuila.proyecto.IService.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaService {
    @Autowired
    private IPersonaRepository repository;

    @Override
    public Persona save(Persona persona) {
        return repository.save(persona);
    }

    @Override
    public void update(Persona persona, Long id) {
        //Buscar si existe el dato con ese id
        Optional<Persona> optional = repository.findById(id);

        //Si existe, se actualiza
        if (optional.isPresent()) {
            Persona personaUpdate = optional.get();
            personaUpdate.setTipoDocumento(persona.getTipoDocumento());
            personaUpdate.setDocumento(persona.getDocumento());
            personaUpdate.setNombre(persona.getNombre());
            personaUpdate.setTelefono(persona.getTelefono());
            personaUpdate.setDireccion(persona.getDireccion());
            repository.save(personaUpdate);
        }else{
            throw new RuntimeException("No existe el registro para actualizar");
        }

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Persona> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Persona> findAll() {
        return repository.findAll();
    }
}
