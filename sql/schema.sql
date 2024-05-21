CREATE TABLE Persona (
    id_persona SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    ocupacion VARCHAR(100)
);

CREATE TABLE Lugar (
    id_lugar SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    departamento_o_estado VARCHAR(100),
    pais VARCHAR(100) NOT NULL,
    persona_id_persona INT,
    CONSTRAINT fk_persona
        FOREIGN KEY (persona_id_persona)
        REFERENCES Persona(id_persona)
);
