package com.corhuila.proyecto.Service;

import com.corhuila.proyecto.Entity.Categoria;
import com.corhuila.proyecto.IRepository.ICategoriaRepository;
import com.corhuila.proyecto.IService.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService {
    @Autowired
    private ICategoriaRepository repository;

    @Override
    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public void update(Categoria categoria, Long id) {
        //Buscar si existe el dato con ese id
        Optional<Categoria> optional = repository.findById(id);

        //Si existe, se actualiza
        if (optional.isPresent()) {
            Categoria categoriaUpdate = optional.get();
            categoriaUpdate.setNombre(categoria.getNombre());
            categoriaUpdate.setDescripcion(categoria.getDescripcion());
            repository.save(categoriaUpdate);
        }else{
            throw new RuntimeException("No existe el registro para actualizar");
        }

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Categoria> findById( Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Categoria> findAll() {
        return repository.findAll();
    }
}
