
# Anthony Padilla - Tarea 1

- Este es el repositorio de la Tarea 1 de Anthony Padilla.

- El profesor u encargado de revisión puede ejecutar el proyecto con una base de datos local o una base de datos montada en Docker.

- En este caso el estudiante seleccionó montarla en Docker y editó el archivo `resources/application.properties` de la siguiente forma:

```
spring.application.name=tarea1
spring.datasource.url=jdbc:mysql://localhost:3306/tarea1
spring.datasource.username=apadilla
spring.datasource.password=#tarea1
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
security.jwt.secret-key=3cfa76ef14937c1c0ea519f8fc057a80fcd04a7420f8e8bcd0a7567c272e007b
security.jwt.expiration-time=3600000
```

## Requisitos

Para ejecutar el proyecto, se puede utilizar una base de datos local o una base de datos montada en Docker. A continuación se presentan las instrucciones para ambos métodos:

### Opción 1: Base de datos montada en Docker

1. **Instalar Docker:** Asegúrate de tener Docker y Compose instalado en tu sistema. Puedes descargarlo e instalarlo desde [Docker's official website](https://www.docker.com/get-started).

2. **Configurar y ejecutar el contenedor de MySQL:** Utiliza el siguiente comando de Compose para crear y ejecutar un contenedor de MySQL.

    ```bash
    docker compose up -d
    ```

3. **Verificar el estado del contenedor:** Asegúrate de que el contenedor esté en ejecución.

    ```bash
    docker ps
    ```

### Opción 2: Base de datos local

Si prefieres utilizar una base de datos local, sigue estos pasos:

1. **Instalar MySQL o MariaDB:** Asegúrate de tener MySQL instalado en tu sistema. Puedes descargarlo e instalarlo desde [MySQL's official website](https://dev.mysql.com/downloads/mysql/).

2. **Crear la base de datos y el usuario:** Abre una terminal y ejecuta los siguientes comandos en el cliente de MySQL (Puede usar los usuarios y contraseñas que desee, solo edite el archivo `resources/application.properties`):

    ```sql
    CREATE DATABASE tarea1;
    CREATE USER 'apadilla'@'localhost' IDENTIFIED BY '#tarea1';
    GRANT ALL PRIVILEGES ON tarea1.* TO 'apadilla'@'localhost';
    FLUSH PRIVILEGES;
    ```

3. **Editar el archivo `application.properties`:** Asegúrate de que las propiedades en `resources/application.properties` estén configuradas de la siguiente manera (o según su configuración dependiente de lo que haya hecho en el paso anterior):

    ```properties
    spring.application.name=tarea1
    spring.datasource.url=jdbc:mysql://localhost:3306/tarea1
    # spring.datasource.url=jdbc:mariadb://localhost:3306/tarea1
    spring.datasource.username=apadilla
    spring.datasource.password=#tarea1
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    # spring.jpa.database-platform=org.hibernate.dialect.MariaDBDialect
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
    security.jwt.secret-key=3cfa76ef14937c1c0ea519f8fc057a80fcd04a7420f8e8bcd0a7567c272e007b
    security.jwt.expiration-time=3600000
    ```

Con estos pasos, tu proyecto debería estar listo para ser ejecutado con éxito, ya sea utilizando Docker o una base de datos local.

## Instrucciones

### 1. Clonar el repositorio

Primero, clona el repositorio a tu máquina local, verifica tener Java instalado:

```bash
git clone https://github.com/Niruchie/ProyectoIII-TareaI.git
cd ProyectoIII-TareaI
```

### 2. Ejecutar el projecto con tu editor o IDE favorito

- En mi caso, yo utilizé Eclipse IDE - 20.XX para levantar el proyecto

### Notas

- Asegúrate de que el puerto `3306` no esté siendo utilizado por otro servicio en tu máquina local.
- Para cambiar el dialecto o configuración de la base de datos puedes ir al archivo `resources/application.properties`.


Si usas Docker:

- Si requiere cambiar alguna configuración de Docker, puedes hacerlo en el `compose.yaml` según tus necesidades.
