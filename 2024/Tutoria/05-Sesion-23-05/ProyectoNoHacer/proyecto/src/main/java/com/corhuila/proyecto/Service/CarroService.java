package com.corhuila.proyecto.Service;

import com.corhuila.proyecto.Entity.Carro;
import com.corhuila.proyecto.IRepository.ICarroRepository;
import com.corhuila.proyecto.IService.ICarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService implements ICarroService {
    @Autowired
    private ICarroRepository repository;

    @Override
    public Carro save(Carro Carro) {
        return repository.save(Carro);
    }

    @Override
    public void update(Carro carro, Long id) {
        //Buscar si existe el dato con ese id
        Optional<Carro> optional = repository.findById(id);

        //Si existe, se actualiza
        if (optional.isPresent()) {
            Carro carroUpdate = optional.get();
            carroUpdate.setMarca(carro.getMarca());
            carroUpdate.setModelo(carro.getModelo());
            carroUpdate.setPlaca(carro.getPlaca());
            carroUpdate.setColor(carro.getColor());
            carroUpdate.setCategoriaId(carro.getCategoriaId());
            repository.save(carroUpdate);
        }else{
            throw new RuntimeException("No existe el registro para actualizar");
        }

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Carro> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Carro> findAll() {
        return repository.findAll();
    }
}
