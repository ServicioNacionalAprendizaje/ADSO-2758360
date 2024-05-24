package com.corhuila.proyecto.Controller;

import com.corhuila.proyecto.Entity.Usuario;
import com.corhuila.proyecto.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService service;

    @PostMapping("")
    public Usuario save(@RequestBody Usuario usuario){
         return service.save(usuario);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Usuario usuario, @PathVariable Long id){
        service.update(usuario, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("")
    public List<Usuario> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> findById(@PathVariable Long id){
        return service.findById(id);
    }
}
