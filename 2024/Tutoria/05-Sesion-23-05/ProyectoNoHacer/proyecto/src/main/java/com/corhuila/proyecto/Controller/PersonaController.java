package com.corhuila.proyecto.Controller;

import com.corhuila.proyecto.Entity.Persona;
import com.corhuila.proyecto.IService.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/persona")
public class PersonaController {

    @Autowired
    IPersonaService service;

    @PostMapping("")
    public Persona save(@RequestBody Persona persona){
         return service.save(persona);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Persona persona, @PathVariable Long id){
        service.update(persona, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("")
    public List<Persona> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Persona> findById(@PathVariable Long id){
        return service.findById(id);
    }
}
