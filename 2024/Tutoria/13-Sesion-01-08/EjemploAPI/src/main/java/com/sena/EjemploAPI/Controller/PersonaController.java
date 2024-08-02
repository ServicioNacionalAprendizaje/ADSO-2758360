package com.sena.EjemploAPI.Controller;

import com.sena.EjemploAPI.Entity.Persona;
import com.sena.EjemploAPI.IService.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("v1/api/persona")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @GetMapping()
    public List<Persona> All() {
        return service.All();
    }

    @GetMapping("/{id}")
    public Optional<Persona> FindById(@PathVariable Long id) {
        return service.FindById(id);
    }

    @PostMapping()
    public Persona Save(@RequestBody Persona persona) {
        return service.Save(persona);
    }

    @PutMapping("/{id}")
    public void Update(@RequestBody Persona persona, @PathVariable Long id) {
        service.Update(persona,id);
    }

    @DeleteMapping("/{id}")
    public void Datele(@PathVariable Long id) {
        service.Datele(id);
    }
}
