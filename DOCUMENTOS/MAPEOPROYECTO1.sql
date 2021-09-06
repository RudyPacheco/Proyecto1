
------SQL----------

CREATE DATABASE mi_muebleria;

CREATE TABLE usuario(
nombre_usuario VARCHAR(20) NOT NULL,
contraseña VARCHAR(12) NOT NULL,
codigo_area INT NOT NULL,
bloqueado BOOLEAN NOT NULL,
CONSTRAINT PK_USUARIO PRIMARY KEY(nombre_usuario)
);

CREATE TABLE cliente(
nombre_cliente VARCHAR(45) NOT NULL,
nit VARCHAR(13) NOT NULL,
direccion VARCHAR(20) NOT NULL,
municipio VARCHAR(30),
departamento VARCHAR(30) ,
CONSTRAINT PK_CLIENTE PRIMARY KEY(nit)
);


CREATE TABLE muebles_sin_registrar(
id_mueble VARCHAR(20) NOT NULL,
nombre VARCHAR(45) NOT NULL,
fecha_ensamble DATE NOT NULL,
usuario_ensamble VARCHAR(20) NOT NULL,
costo DECIMAL(9,2) NOT NULL,
precio DECIMAL(9,2) NOT NULL,
CONSTRAINT PK_MUEBLESR PRIMARY KEY(id_mueble),
CONSTRAINT FK_TO_USUARIO FOREIGN KEY(usuario_ensamble)
REFERENCES usuario(nombre_usuario)
);

CREATE TABLE muebles_registrados(
id_mueble_registrado VARCHAR(20) NOT NULL,
nombre VARCHAR(45) NOT NULL,
fecha_ensamble DATE NOT NULL,
usuario_ensamble VARCHAR(20) NOT NULL,
costo DECIMAL(9,2) NOT NULL,
precio DECIMAL(9,2) NOT NULL,
CONSTRAINT PK_MUEBLER PRIMARY KEY(id_mueble_registrado),
CONSTRAINT FK_TO_USUARIO1 FOREIGN KEY(usuario_ensamble)
REFERENCES usuario(nombre_usuario)
);

CREATE TABLE muebles_vendidos(
id_mueble VARCHAR(20) NOT NULL,
nombre VARCHAR(45) NOT NULL,
fecha_ensamble DATE NOT NULL,
fecha_venta DATE NOT NULL,
usuario_ensamble VARCHAR(20) NOT NULL,
usuario_venta VARCHAR(20) NOT NULL,
costo DECIMAL(9,2) NOT NULL,
precio DECIMAL(9,2) NOT NULL,
CONSTRAINT PK_MUEBLEV PRIMARY KEY(id_mueble),
CONSTRAINT FK_TO_USUARIO2 FOREIGN KEY(usuario_ensamble)
REFERENCES usuario(nombre_usuario)
);

CREATE TABLE muebles_devueltos(
id_mueble VARCHAR(20) NOT NULL,
nombre VARCHAR(45) NOT NULL,
fecha_ensamble DATE NOT NULL,
fecha_venta DATE NOT NULL,
fecha_regreso DATE NOT NULL,
usuario_ensamble VARCHAR(20) NOT NULL,
costo DECIMAL(9,2) NOT NULL,
precio DECIMAL(9,2) NOT NULL,
CONSTRAINT PK_MUEBLED PRIMARY KEY(id_mueble),
CONSTRAINT FK_TO_USUARIO3 FOREIGN KEY(usuario_ensamble)
REFERENCES usuario(nombre_usuario)
);

CREATE TABLE pieza_registrada(
nombre_pieza VARCHAR(45) NOT NULL,
cantidad  int NOT NULL,
CONSTRAINT PK_PIEZAR PRIMARY KEY(nombre_pieza)
);

CREATE TABLE pieza_disponible(
id_pieza int NOT NULL AUTO_INCREMENT,
nombre_pieza VARCHAR(45) NOT NULL,
precio DECIMAL(7,2) NOT NULL,
CONSTRAINT PK_PIEZAD PRIMARY KEY(id_pieza)
);

CREATE TABLE mueble_receta(
id int NOT NULL AUTO_INCREMENT,
nombre_mueble VARCHAR(45) NOT NULL,
pieza_necesaria VARCHAR(45) NOT NULL,
cantidad INT NOT NULL,
CONSTRAINT PK_MUEBLE_RECETA PRIMARY KEY(id)
);

CREATE TABLE mueble(
nombre_mueble VARCHAR(45) NOT NULL,
precio DECIMAL(9,2) NOT NULL,
CONSTRAINT PK_MUEBLE PRIMARY KEY(nombre_mueble)
);


CREATE TABLE factura(
id_factura VARCHAR(45) NOT NULL,
fecha_compra DATE NOT NULL,
nit VARCHAR(13) NOT NULL,
nombre_usuario VARCHAR(20) NOT NULL,
total DECIMAL(9,2) NOT NULL,
CONSTRAINT PK_FACTURA PRIMARY KEY(id_factura),
CONSTRAINT FK_TO_CLIENTE FOREIGN KEY(nit)
REFERENCES cliente(nit),
);

CREATE TABLE detalle(
num_detalle INT NOT NULL,
id_factura VARCHAR(45) NOT NULL,
id_mueble VARCHAR(20) NOT NULL,
nobreMueble VARCHAR(45) NOT NULL,
precio DECIMAL(9,2) NOT NULL,
CONSTRAINT PK_DETALLE PRIMARY KEY(num_detalle,id_factura),
CONSTRAINT FK_TO_FACTURA FOREIGN KEY(id_factura)
REFERENCES factura(id_factura),
CONSTRAINT FK_TO_MUEBLER FOREIGN KEY(id_mueble)
REFERENCES muebles_registrados(id_mueble_registrado)
);


CREATE TABLE piezas_usadas(
id_mueble VARCHAR(20),
id_pieza int NOT NULL,
nombre_pieza VARCHAR(45) NOT NULL,
precio DECIMAL(7,2) NOT NULL,
CONSTRAINT PK_PIEZAD PRIMARY KEY(id_pieza)
)


CREATE USER 'system32'@'localhost' IDENTIFIED BY 'password';
GRANT SELECT , INSERT

GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP
    -> ON mi_muebleria.*
    -> TO 'system32'@'localhost';

    FLUSH PRIVILEGES;