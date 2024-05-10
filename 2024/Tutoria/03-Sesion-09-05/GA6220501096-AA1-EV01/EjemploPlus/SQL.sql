drop database if exists bibloteca;
create database bibloteca;
use bibloteca;

create table autor(
	id int primary KEY auto_increment,
    nombre varchar(50) not null,
    correo varchar(50) not null,
    telefono varchar(50) not null
);

create table categoria(
	id int primary KEY auto_increment,
    codigo varchar(10) not null,
    nombre varchar(50) not null,
    descripcion varchar(50) not null
);

create table libro(
	id int primary KEY auto_increment,
    isbn varchar(50) not null,
    nombre varchar(50) not null,
    descripcion varchar(50) not null,
    num_pag int not null,
    autor_id int,
    categoria_id int,
    foreign key (autor_id) references autor(id),
    foreign key (categoria_id) references categoria(id)
);


-- Insertar datos
INSERT INTO autor(nombre, correo, telefono)VALUES
('Jesús','jag@gmail.com','3015554646'),
('María','maria@gmail.com','320234237');

INSERT INTO categoria(codigo, nombre, descripcion)VALUES
('101','Novelas','Son novelas romanticas, y de caos'),
('1023','Terror','Libros representativos en el terror');

INSERT INTO libro(isbn, nombre, descripcion, num_pag, autor_id, categoria_id)VALUES
('6723512BS','100 Años de Soledad','Libro de autor colombiano, Gabriel..', 233,2,1),
('432BhA34','Thor','Libro de terror',423,1,2);


select * from libro;