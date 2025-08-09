# Literalura

## Descripción

Literalura es una aplicación de consola que permite buscar información de libros en una API, guardar esos datos en una base de datos y mostrar al usuario los libros almacenados. También permite filtrar los libros por idioma y listar autores filtrándolos según una fecha en la que se encuentren con vida.

## Tecnologías utilizadas

- Java
- Spring Boot
- PostgreSQL
- Spring Web
- JPA / Hibernate
- JSON

## Requisitos previos

- **Java Development Kit (JDK 11 o superior)**  
  Para compilar y ejecutar la aplicación Java.

- **PostgreSQL**  
  Para la base de datos donde se almacenarán los datos.

- **Maven o Gradle (opcional)**  
  Para gestionar dependencias y construir el proyecto (si usas un IDE que lo maneje, puede ser opcional).

- **IDE (opcional pero recomendado)**  
  Como IntelliJ IDEA, Eclipse o VSCode para facilitar el desarrollo y ejecución.

## Instalación y ejecución

1. Clona este repositorio:

   ```bash
   git clone https://github.com/Big-Zanahorio/literalura.git
   cd literalura
   ```

2. Configura la conexión a la base de datos PostgreSQL en el archivo de configuración (`application.properties` o `application.yml`).

3. Construye el proyecto con Maven o Gradle:

   ```bash
   mvn clean install
   ```

   o

   ```bash
   ./gradlew build
   ```

4. Ejecuta la aplicación:

   ```bash
   mvn spring-boot:run
   ```

   o ejecuta la clase principal desde tu IDE.

## Uso

- La aplicación te permitirá buscar libros usando la API externa.
- Guardará los datos de libros y autores en la base de datos.
- Podrás listar los libros guardados y filtrarlos por idioma.
- También podrás listar autores y filtrarlos según una fecha para ver quiénes estaban vivos.

## Autor

Carlos Alberto Ramirez Monarrez
