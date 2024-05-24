https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.2.5&packaging=jar&jvmVersion=17&groupId=com.corhuila&artifactId=proyecto&name=proyecto&description=Creaci%C3%B3n%20de%20API&packageName=com.corhuila.proyecto&dependencies=web,devtools,data-jpa,mysql

Nota: se usa el ORM JPA

Entity
Dto
IRepository
IService
Service
Controller

1. Configurar application.properties
```java
spring.application.name=estructura
server.port= 9000
spring.jpa.hibernate.ddl-auto = update
spring.datasource.url = jdbc:mysql://localhost:3306/estructura
spring.datasource.username = root
spring.datasource.password = abcd
```

1. Garantizar que este creada la base de datos y datos de auth esten correctos. 
```sql
    DROP DATABASE IF EXISTS estructura;
    CREATE DATABASE estructura;
    USE estructura;
```