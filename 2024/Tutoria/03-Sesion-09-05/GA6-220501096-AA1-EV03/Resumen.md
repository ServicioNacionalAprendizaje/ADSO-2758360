# Creaer colección de datos  (BD NOSQL)

**Sistema de biblioteca:** En un sistema de biblioteca, para organizar los libros por autores, categorias y libros. 
* Se sabe que un autor puede escribir uno o mucho libros
* Se sabe que un libro puede tener una única categoría

**Análisis:** Se requiere de las siguientes entidades
1. Autor[nombre, correo, telefono]
2. Categoria[codigo, nombre, descripcion]
3. Libro[ISBN, nombre, descripcion, numero_pagina, `ref`:Autor, `ref`:Categoria]


# Manual básico. 

1. Ingresar a mongo por terminar `mongo`
2. Mostrar base de datos existentes `show dbs`
3. Para eliminar una base de datos debe primero seleccionar con `use `+`nombre de la base de datos`, luego `db.dropDatabase()`
4. Para crerar una base de datos debe usar el comando  `use `+`nombre a usar`, ejemplo `use biblioteca`
5. Para poder ver la base de datos recien creada, debe como mínimo, crear una collection. `db.createCollection("datos")`
6. Vamos a llenar unos datos de prueba, se sabe que en nosql (mongo, se usa json)


**Ejempo**
```javascript
  db.datos.insert({
    "libro":{
        "autor":{
            "nombre":"Jesús",
            "correo":"sdasj@gmail.com",
            "telefono":"3015554646"
        },
        "categoria":{
            "nombre":"Terror"
        },
        "isbn":"3746dhsjf",
        "nombre":"Ingeniería de Software",
        "num_pag":478
    }  
  })  
```

Consultar lo que se agrego anteriormente. `db.datos.find()` o `db.datos.find().pretty()` 

**Ejempo**
```javascript
  db.datos.insert({
    "libro":{
        "autor":{
            "nombre":"María Sofia",
            "direccion":"Calle 34"
        },
        "nombre":"Prueba",
        "isbn":"jfdskf3",
        "nombre":"Ingeniería de Sistemas",
        "num_pag":478
    }  
  })  
```