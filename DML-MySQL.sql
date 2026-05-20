INSERT INTO usuarios (nombre, fecha_nacimiento, telefono, email) VALUES 
('Julián Mesa', '1985-05-20', '600123456', 'jmesa@libreria.com'),
('Beatriz Soto', '1992-11-03', '600987654', 'bsoto@libreria.com'),
('Carlos Ruiz', '1988-03-12', '600000001', 'cruiz@libreria.com'),
('Ana Belén', '1995-07-22', '600000002', 'abelen@libreria.com'),
('Ricardo Gómez', '1980-01-15', '600000003', 'rgomez@libreria.com'),
('Lucía Fernández', '1993-11-30', '600000004', 'lfernandez@libreria.com'),
('Marcos Paez', '1990-05-05', '600000005', 'mpaez@libreria.com'),
('Sofía Vega', '1987-09-18', '600000006', 'svega@libreria.com'),
('David Sanz', '1994-02-25', '600000007', 'dsanz@libreria.com'),
('Elena Cano', '1991-08-14', '600000008', 'ecano@libreria.com'),
('Javier López', '1985-12-10', '600000009', 'jlopez@libreria.com'),
('Marta Gil', '1996-04-03', '600000010', 'mgil@libreria.com'),
('Pablo Mora', '1982-06-21', '600000011', 'pmora@libreria.com'),
('Irene Soler', '1998-10-12', '600000012', 'isoler@libreria.com'),
('Hugo Rivas', '1989-03-29', '600000013', 'hrivas@libreria.com'),
('Clara Diez', '1992-01-08', '600000014', 'cdiez@libreria.com'),
('Raúl Castro', '1986-11-11', '600000015', 'rcastro@libreria.com');


INSERT INTO clientes (nombre, fecha_nacimiento, telefono, email, direccion) VALUES 
('Alberto García', '1975-02-14', '655111222', 'alberto.g@email.com', 'Calle Mayor 12'),
('Elena Martínez', '1998-08-30', '655444555', 'emartinez@email.com', 'Avenida Central 45'),
('Roberto Solis', '1982-04-10', '655000001', 'roberto@email.com', 'Calle Luna 4'),
('Laura Peña', '1995-12-05', '655000002', 'lpena@email.com', 'Plaza Mayor 1'),
('Miguel Rivas', '1970-08-20', '655000003', 'mrivas@email.com', 'Av. De la Paz 12'),
('Sandra Luz', '1999-01-15', '655000004', 'sluz@email.com', 'Calle Estrecha 22'),
('Jorge Herrero', '1988-06-30', '655000005', 'jherrero@email.com', 'Paseo del Prado 9'),
('Isabel Torres', '1992-03-12', '655000006', 'itorres@email.com', 'Calle Nueva 56'),
('Fernando Rey', '1978-09-25', '655000007', 'frey@email.com', 'Calle Olvido 13'),
('Carmen Ortiz', '1985-11-02', '655000008', 'cortiz@email.com', 'Calle Real 100'),
('Antonio Bueno', '2001-05-20', '655000009', 'abueno@email.com', 'Av. Constitución 4'),
('Mónica Silva', '1994-07-08', '655000010', 'msilva@email.com', 'Calle Sol 2'),
('Pedro Duarte', '1980-02-28', '655000011', 'pduarte@email.com', 'Plaza España 5'),
('Rosa Blanca', '1997-10-14', '655000012', 'rblanca@email.com', 'Calle Mayor 50'),
('Luis Miguel', '1983-04-19', '655000013', 'lmiguel@email.com', 'Calle Alcala 12'),
('Sara Connor', '1990-12-12', '655000014', 'sconnor@email.com', 'Calle Futuro 1984'),
('Victor Hugo', '1975-06-06', '655000015', 'vhugo@email.com', 'Calle Francesa 10');


INSERT INTO autores (nombre, nacionalidad, fecha_nacimiento, biografia) VALUES 
('Gabriel García Márquez', 'Colombiana', '1927-03-06', 'Premio Nobel de Literatura en 1982.'),
('George R.R. Martin', 'Estadounidense', '1948-09-20', 'Autor de la saga Canción de Hielo y Fuego.'),
('Isabel Allende', 'Chilena', '1942-08-02', 'Escritora de La Casa de los Espíritus.'),
('Stephen King', 'Estadounidense', '1947-09-21', 'Maestro del terror contemporáneo.'),
('J.K. Rowling', 'Británica', '1965-07-31', 'Creadora del universo de Harry Potter.'),
('Haruki Murakami', 'Japonesa', '1949-01-12', 'Autor de Tokyo Blues y Kafka en la orilla.'),
('Julio Cortázar', 'Argentina', '1914-08-26', 'Gran innovador del relato corto y la novela.'),
('Ernest Hemingway', 'Estadounidense', '1899-07-21', 'Ganador del Nobel y autor de El viejo y el mar.'),
('Jane Austen', 'Británica', '1775-12-16', 'Autora de Orgullo y Prejuicio.'),
('Jorge Luis Borges', 'Argentina', '1899-08-24', 'Figura clave de la literatura en español.'),
('Agatha Christie', 'Británica', '1890-09-15', 'La reina del misterio.'),
('Miguel de Cervantes', 'Española', '1547-09-29', 'Autor de Don Quijote de la Mancha.'),
('Toni Morrison', 'Estadounidense', '1931-02-18', 'Primera mujer afroamericana en ganar el Nobel.'),
('Umberto Eco', 'Italiana', '1932-01-05', 'Autor de El nombre de la rosa.'),
('Virginia Woolf', 'Británica', '1882-01-25', 'Pionera del modernismo literario.'),
('Franz Kafka', 'Checa', '1883-07-03', 'Autor de La Metamorfosis.'),
('Oscar Wilde', 'Irlandesa', '1854-10-16', 'Autor de El retrato de Dorian Gray.');


INSERT INTO categorias (nombre_categoria) VALUES 
('Realismo Mágico'), ('Fantasía'), ('Novela Histórica'), ('Terror'), 
('Ciencia Ficción'), ('Romance'), ('Policial'), ('Clásicos'), 
('Biografía'), ('Ensayo'), ('Aventura'), ('Juvenil'), 
('Poesía'), ('Drama'), ('Suspenso'), ('Infantil'), 
('Autoayuda'), ('Cómic');


INSERT INTO libros (id_autor, id_categoria, nombre, isbn, editorial, ano_publicacion, precio, stock) VALUES 
(3, 1, 'La casa de los espíritus', '978-8401341588', 'Plaza Janés', 1982, 19.00, 15),
(4, 6, 'It', '978-8401337185', 'Plaza  Janés', 1986, 28.50, 10),
(5, 2, 'Harry Potter y la piedra filosofal', '978-8478884452', 'Salamandra', 1997, 15.95, 50),
(6, 1, 'Kafka en la orilla', '978-8483104408', 'Tusquets', 2002, 21.00, 12),
(7, 1, 'Rayuela', '978-8420437439', 'Alfaguara', 1963, 22.90, 8),
(8, 1, 'El viejo y el mar', '978-8497598064', 'Debolsillo', 1952, 11.50, 20),
(9, 1, 'Orgullo y Prejuicio', '978-8491051329', 'Penguin Clásicos', 1813, 14.95, 25),
(10, 1, 'El Aleph', '978-8466332422', 'Debolsillo', 1949, 13.00, 18),
(11, 4, 'Diez negritos', '978-8467049442', 'Espasa', 1939, 12.50, 30),
(12, 1, 'Don Quijote de la Mancha', '978-8424116316', 'Everest', 1605, 26.00, 5),
(13, 1, 'Beloved', '978-8490628072', 'Debolsillo', 1987, 16.90, 14),
(14, 4, 'El nombre de la rosa', '978-8426418524', 'Lumen', 1980, 20.00, 22),
(15, 1, 'Al faro', '978-8420655055', 'Alianza', 1927, 10.95, 9),
(16, 1, 'La Metamorfosis', '978-8420651361', 'Alianza', 1915, 9.50, 40),
(17, 1, 'El retrato de Dorian Gray', '978-8467049381', 'Austral', 1890, 11.00, 15);


INSERT INTO ventas (id_cliente, id_usuario, estado_pago) VALUES 
(1, 1, 'Completado'),
(2, 2, 'Pendiente'),
(9, 3, 'Completado'),
(4, 5, 'Completado'),
(5, 2, 'Pendiente'),
(6, 7, 'Cancelado'),
(17, 3, 'Completado'),
(12, 9, 'Pendiente'),
(2, 4, 'Completado'),
(8, 1, 'Procesando'),
(9, 10, 'Completado'),
(10, 2, 'Cancelado'),
(3, 17, 'Completado'),
(5, 8, 'Pendiente'),
(7, 11, 'Completado'),
(14, 3, 'Procesando'),
(6, 12, 'Completado');


INSERT INTO detalle_venta (id_venta, id_libro, cantidad, precio_aplicado) VALUES 
(1, 1, 1, 18.90),
(2, 2, 1, 26.50),
(3, 3, 1, 19.00),
(4, 4, 1, 28.50),
(5, 5, 2, 15.95),
(6, 6, 1, 21.00),
(7, 7, 1, 22.90),
(8, 8, 3, 11.50),
(9, 9, 1, 14.95),
(10, 10, 1, 13.00),
(11, 11, 2, 12.50),
(12, 12, 1, 26.00),
(13, 13, 1, 16.90),
(14, 14, 1, 20.00),
(15, 15, 1, 10.95),
(16, 3, 5, 9.50),
(17, 12, 1, 11.00);