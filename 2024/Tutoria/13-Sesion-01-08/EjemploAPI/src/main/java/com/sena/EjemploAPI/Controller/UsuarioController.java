package com.sena.EjemploAPI.Controller;

import com.sena.EjemploAPI.Entity.Usuario;
import com.sena.EjemploAPI.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("v1/api/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService service;

    @GetMapping()
    public List<Usuario> All() {
        return service.All();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> FindById(@PathVariable Long id) {
        return service.FindById(id);
    }

    @PostMapping()
    public Usuario Save(@RequestBody Usuario usuario) {
        return service.Save(usuario);
    }

    @PutMapping("/{id}")
    public void Update(@RequestBody Usuario usuario, @PathVariable Long id) {
        service.Update(usuario,id);
    }

    @DeleteMapping("/{id}")
    public void Datele(@PathVariable Long id) {
        service.Datele(id);
    }
}
