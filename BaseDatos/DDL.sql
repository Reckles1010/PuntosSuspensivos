CREATE TABLE usuarios (
    id_usuario NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    telefono VARCHAR2(20),
    email VARCHAR2(45) UNIQUE NOT NULL,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE clientes (
    id_cliente NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR2(150) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    telefono VARCHAR2(20),
    email VARCHAR2(45),
    direccion VARCHAR2(45),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE autores (
    id_autor NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL,
    nacionalidad VARCHAR2(50),
    fecha_nacimiento DATE NOT NULL,
    biografia CLOB
);

CREATE TABLE categorias (
    id_categoria NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre_categoria VARCHAR2(50) NOT NULL
);

CREATE TABLE libros (
    id_libro NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_autor NUMBER,
    id_categoria NUMBER,
    nombre VARCHAR2(45) NOT NULL,
    isbn VARCHAR2(20) UNIQUE,
    editorial VARCHAR2(100),
    descripcion CLOB,
    ano_publicacion NUMBER,
    precio NUMBER(10,2) NOT NULL,
    stock NUMBER DEFAULT 0,
    CONSTRAINT fk_autor_libro FOREIGN KEY (id_autor) REFERENCES autores(id_autor),
    CONSTRAINT fk_categoria_libro FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria)
);

CREATE TABLE ventas (
    id_venta NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_cliente NUMBER NOT NULL,
    id_usuario NUMBER NOT NULL,
    fecha_venta TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado_pago VARCHAR2(50) DEFAULT 'Pendiente',
    CONSTRAINT fk_cliente FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

CREATE TABLE detalle_venta (
    id_detalle NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_venta NUMBER NOT NULL,
    id_libro NUMBER NOT NULL,
    cantidad NUMBER NOT NULL,
    precio_aplicado NUMBER(10,2) NOT NULL,
    CONSTRAINT fk_venta FOREIGN KEY (id_venta) REFERENCES ventas(id_venta) ON DELETE CASCADE,
    CONSTRAINT fk_libro FOREIGN KEY (id_libro) REFERENCES libros(id_libro)
);
