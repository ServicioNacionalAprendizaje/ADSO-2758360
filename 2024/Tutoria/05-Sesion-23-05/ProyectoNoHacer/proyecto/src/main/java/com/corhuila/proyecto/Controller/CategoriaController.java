package com.corhuila.proyecto.Controller;

import com.corhuila.proyecto.Entity.Categoria;
import com.corhuila.proyecto.IService.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/categoria")
public class CategoriaController {
    @Autowired
    ICategoriaService service;

    @PostMapping("")
    public Categoria save(@RequestBody Categoria categoria){
         return service.save(categoria);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Categoria categoria, @PathVariable Long id){
        service.update(categoria, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping
    public List<Categoria> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> findById(@PathVariable Long id){
        return service.findById(id);
    }
}
