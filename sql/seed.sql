-- Insertar datos en la tabla Persona
INSERT INTO Persona(nombre, edad, ocupacion) VALUES
    ('Juan Perez', 30, 'Engineer'),
    ('Maria Gomez', 25, 'Doctor'),
    ('Carlos Ruiz', 40, 'Teacher'),
    ('Ana Torres', 35, 'Lawyer');


INSERT INTO Lugar(nombre, departamento_o_estado, pais, persona_id_persona) VALUES
    ('Plaza Mayor', 'Antioquia', 'Colombia', 1),
    ('Eiffel Tower', 'Île-de-France', 'France', 2),
    ('Great Wall', 'Beijing', 'China', 3),
    ('Statue of Liberty', 'New York', 'USA', 1),
    ('Machu Picchu', 'Cusco', 'Peru', 2),
    ('Taj Mahal', 'Uttar Pradesh', 'India', 4),
    ('Grand Canyon', 'Arizona', 'USA', 3),
    ('Grand Canyon', 'Arizona', 'USA', 2),
    ('Machu Picchu', 'Cusco', 'Peru', 4),
    ('Christ the Redeemer', 'Rio de Janeiro', 'Brazil', 4);
