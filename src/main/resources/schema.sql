DROP TABLE IF EXISTS categorias;

CREATE TABLE categorias (
                                id_categoria BIGINT AUTO_INCREMENT  PRIMARY KEY,
                                nombre VARCHAR(250) NOT NULL
);


DROP TABLE IF EXISTS productos;

CREATE TABLE productos (
                              id BIGINT AUTO_INCREMENT  PRIMARY KEY,
                              producto VARCHAR(250) NOT NULL,
                              descripcion VARCHAR(250) NOT NULL,
                              stock DOUBLE,
                              precio DOUBLE,
                              estado VARCHAR(250) NOT NULL,
                              creado_En TIMESTAMP,
                              id_categoria BIGINT
);