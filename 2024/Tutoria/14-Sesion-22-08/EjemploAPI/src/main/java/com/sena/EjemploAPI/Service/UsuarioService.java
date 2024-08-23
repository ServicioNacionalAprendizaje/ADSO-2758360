package com.sena.EjemploAPI.Service;

import com.sena.EjemploAPI.Entity.Usuario;
import com.sena.EjemploAPI.IRepository.IUsuarioRepository;
import com.sena.EjemploAPI.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository repository;

    @Override
    public List<Usuario> All() {
        return repository.findAll();
    }

    @Override
    public Optional<Usuario> FindById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Usuario Save(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public void Update(Usuario usuario, Long id) {
        //Verificar si existe
        Optional<Usuario> op = repository.findById(id);

        //Verficar si el objeto op esta lleno o vacio.
        if(op.isEmpty()){
            System.out.print("Registro no existe.");
        }else {
            Usuario updateUsuario = op.get();
            updateUsuario.setUsuario(usuario.getUsuario());
            updateUsuario.setContrasenia(usuario.getContrasenia());
            updateUsuario.setPersonaId(usuario.getPersonaId());

            repository.save(updateUsuario);
        }
    }

    @Override
    public void Datele(Long id) {
        repository.deleteById(id);
    }
}
