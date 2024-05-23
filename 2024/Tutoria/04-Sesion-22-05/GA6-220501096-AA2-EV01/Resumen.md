# Recorrido de la pirámide de los datos

**Base de Datos:** Almacena datos de manera organizada y es accesible.

- **Byte:** Representa un carácter. => [/]
- **Dato:** Es un conjunto de caracteres. [CC]
- **Registro:** Es un conjunto de datos. [CC 1079 Jesús González]
- **Información:** Es un conjunto de registros.
  - Información de Aprendices de la ficha 360
    - [CC 1079 Jesús González]
    - [CC 1080 Camila Gutierrez]
    - [TI 1023 Andréz Gomez]

**Base de datos:** Es un conjunto o conglomerado de información, y esta a su vez está relacionada.
  - Información de Aprendices de la ficha 360
    - [CC 1079 Jesús González]
    - [CC 1080 Camila Gutierrez]
    - [TI 1023 Andréz Gomez]
  - Información de Programas de Formación
    - [321321 Multimedia]
    - [768432 Análisis y Desarrollo de Software]
    - [463246 Cocina]
  - Matrícula
    - [1079 => 768432]
    - [1080 => 768432]
    - [1023 => 321321]

**Gestión del Conocimiento:** Es el acceso a la información, manipulación y toma de decisiones. Será la cúspide de la pirámide de los datos, ya que mediante estos, una persona o empresa pueden tomar decisiones basadas en un conocimiento argumentado sobre los datos.

*Importante:* Existe el conocimiento tácito, que la persona o empresa sabe hacer, desarrollar o construir, pero no está documentado físicamente. Para el caso del conocimiento explícito, este está totalmente documentado.

**Ejemplo:**
La asistencia a las tutorías de la ficha 360 es superior al 6% desde el inicio del proceso formativo.

Total de Aprendices => 50.
Obtener el porcentaje de asistencia de cada clase:
  - Clase 1: 56%
  - Clase 2: 4%
  - Clase 3: 12%
Ponderar los porcentajes:

Total = (56+4+12)/3

El porcentaje de asistencia de las tres clases es del 24%

---

## Recorrido sobre la construcción de base de datos en motores SQL (Base de datos relacionales)

**Base de datos relacionales**

- **MER:** Modelo Entidad Relación
- **MR:** Modelo Relacional

	* **Entidades**
	* **Atributos**
	* **Relaciones**
	* **Cardinalidad**

**Motores de base de datos (SQL):** Corresponde al uso del lenguaje estructurado de consulta (structured query language).

	* Todos los motores relacionales trabajan bajo el lenguaje SQL:
		- **DDL – Data Definition Language** (********)
		- **DQL – Data Query Language**
		- **DML – Data Manipulation Language** (********)
		- **DCL – Data Control Language**
		- **TCL – Transaction Control Language**
	* Motores de base de datos SQL más conocidos:
		- **MySQL** (*****)
		- SQLServer
		- PostgreSQL
		- H2
		- SQLite
		- Oracle Data Base

**DBMS o SMBD:** Sistema Manejador de Base de Datos. Es la herramienta que se utiliza como medio para poder interactuar con el motor de base de datos.

---

## Taller:

1. **Planteamiento:** Crear una base de datos para guardar los datos básicos de las personas [nombre, correo y dirección]
2. **Motor de base de datos:** MySQL
3. **SMBD:** Workbench

---

Para crear la base de datos se usará el lenguaje SQL, sobre la familia DDL:

```sql
CREATE DATABASE datos_basicos;
USE datos_basicos; 
CREATE TABLE persona(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50),
	correo VARCHAR(50),
	direccion VARCHAR(50)
);

Pasar ahora a DML, manipular los datos:
INSERT INTO persona(nombre, correo, direccion) VALUES ('Jesús','ariel5252@','Calle 20');
