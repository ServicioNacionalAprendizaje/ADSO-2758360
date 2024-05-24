package com.corhuila.proyecto.IRepository;

import com.corhuila.proyecto.Entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarroRepository extends JpaRepository<Carro, Long> {

}
