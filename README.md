# Proyecto Prueba Técnica Talento B

## Description

This project is a technical test for Talento B. The goal of the project is to create a REST API that manages places and people, including the ability to create people, create places, query people who have visited a specific place, and query places visited in a specific country.

The project is deployed at the following link: https://pruebatecnicatalentob.onrender.com/api/v1. Please note that the project may take approximately 50 seconds to start correctly after attempting to use the URL.
## Running the Project Locally

There are two ways to run the project locally:

### Option 1: Using Docker Compose

1. Clone the repository:
   ```sh
   git clone https://github.com/JairLeal157/PruebaTecnicaTalentoB.git
   cd  PruebaTecnicaTalentoB
   ```

2. Run Docker Compose:
   ```sh
   docker-compose up
   ```

This option will automatically set up a PostgreSQL database using the env.docker file in the repository.

### Option 2: Using Maven Directly


1. Clone the repository:
   ```sh
   git clone https://github.com/JairLeal157/PruebaTecnicaTalentoB.git
   cd  PruebaTecnicaTalentoB
   ```
2. Add the PostgreSQL database information in the application-local.properties file.
3. Build and run the project using the "local" Maven profile:
   ```sh
   mvn clean install -Plocal -DskipTests
   mvn spring-boot:run -Plocal
   ```

## Accessing Swagger

Once the project is up and running, you can access the API documentation in Swagger through the following link:
http://localhost:8080/api/v1/swagger-ui/index.html
or
https://pruebatecnicatalentob.onrender.com/api/v1/swagger-ui/index.html

Swagger provides API documentation along with the ability to test the endpoints directly from the interface.


## Running Unit Tests

To run the project's unit tests, use the "test" Maven profile:

```sh
mvn clean test -Ptest
```


## Technologies Used

- **Spring Boot**: Main framework for building the API.
- **PostgreSQL**: Relational database used to store the information.
- **Docker**: For containerizing the project and the database.
- **Swagger**: For interactive API documentation.
- **JUnit**: For unit testing.
- **Maven**: For project management and build.

## Main Endpoints

### Create Persona


- **Method**: POST
- **URL**: `/api/v1/personas`


### Create Lugar

- **Método**: POST
- **URL**: `/api/v1/lugares`

### Search People by Place

- **Método**: GET
- **URL**: `/api/v1/personas/lugar/{nombreLugar}`

### Search Places by Country

- **Método**: GET
- **URL**: `/api/v1/lugares/pais/{nombrePais}`
- **Descripción**: Consulta los lugares visitados en un país específico.



## Contact information

- **Nombre**: Jair Santiago Leal Miranda
- **Correo Electrónico**: santiago20028019@gmail.com
- **Teléfono**: 3116151053


