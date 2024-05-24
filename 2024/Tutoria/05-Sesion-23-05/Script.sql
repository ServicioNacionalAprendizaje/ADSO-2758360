-- DDL 
-- CREAR BASE DE DATOS
CREATE DATABASE IF NOT EXISTS shpping_cart;

-- Usar base de datos
USE shpping_cart;

-- Crear tabla
CREATE TABLE IF NOT EXISTS cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,    
    correo VARCHAR(100) NOT NULL,
    telefono VARCHAR(100) NOT NULL,
    direccion VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS categoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    categoria_id INT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);