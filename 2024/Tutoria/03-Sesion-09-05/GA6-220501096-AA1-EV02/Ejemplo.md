# Creaer un MER (Modelo Entiad Relación)

**Sistema de biblioteca:** En un sistema de biblioteca, para organizar los libros por autores, categorias y libros. 
* Se sabe que un autor puede escribir uno o mucho libros
* Se sabe que un libro puede tener una única categoría

**Análisis:** Se requiere de las siguientes entidades
1. Autor[nombre, correo, telefono]
2. Categoria[codigo, nombre, descripcion]
3. Libro[ISBN, nombre, descripcion, numero_pagina, `ref`:Autor, `ref`:Categoria] 