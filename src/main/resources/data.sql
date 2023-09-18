INSERT INTO categorias (id_categoria, nombre) VALUES (1,'Calzados');
INSERT INTO categorias (id_categoria, nombre) VALUES (2,'Ropa');
INSERT INTO categorias (id_categoria, nombre) VALUES (3,'Electronicos');

INSERT INTO productos (producto, descripcion, stock, precio, estado, creado_En, id_categoria) 
VALUES ('Adidas Cloudform utlimate', 'para caminar', 5, 120000.0, 'activo', '2023-09-17', 1);

INSERT INTO productos (producto, descripcion, stock, precio, estado, creado_En, id_categoria) 
VALUES ('Adidas Climate t-shirt', 'para caminar', 5, 29000.0, 'activo', '2023-09-17', 2);

INSERT INTO productos (producto, descripcion, stock, precio, estado, creado_En, id_categoria) 
VALUES ('Apple Watch', 'para caminar', 5, 220000.0, 'activo', '2023-09-17', 3);