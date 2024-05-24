package com.corhuila.proyecto.Controller;

import com.corhuila.proyecto.Entity.Carro;
import com.corhuila.proyecto.Entity.Categoria;
import com.corhuila.proyecto.IService.ICarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/carro")
public class CarroController {

    @Autowired
    ICarroService service;

    @PostMapping("")
    public Carro save(@RequestBody Carro carro){
         return service.save(carro);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Carro carro, @PathVariable Long id){
        service.update(carro, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("")
    public List<Carro> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Carro> findById(@PathVariable Long id){
        return service.findById(id);
    }
}
