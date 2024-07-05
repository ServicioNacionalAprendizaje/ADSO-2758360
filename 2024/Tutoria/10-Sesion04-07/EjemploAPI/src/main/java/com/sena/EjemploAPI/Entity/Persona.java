package com.sena.EjemploAPI.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 50)
    private  String nombre;

    @Column(name = "celular", length = 20)
    private  String celular;

    @Column(name = "correo", length = 50)
    private  String correo;
}
