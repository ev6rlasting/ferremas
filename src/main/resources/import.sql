
-- Insertar roles
INSERT INTO rol (id, nombre) VALUES (1, 'ROLE_LECTOR');
INSERT INTO rol (id, nombre) VALUES (2, 'ROLE_ESCRITOR');


-- Insertar usuarios
INSERT INTO usuario (id, username, password) VALUES (1, 'lector', '$2a$10$iDVcP0ZjLXjY.GjQdau1beMIRU4EJSYMj7dDzagD5b6dROp3ojuG6'); -- lector123
INSERT INTO usuario (id, username, password) VALUES (2, 'escritor', '$2a$10$A7HnRoWYY8T1HBua/1YXge6R8uKejQlIq9LHSSL.4Vj3eqVnepgCu'); -- escritor123

-- Asociar usuarios con roles
INSERT INTO usuario_roles (usuario_id, rol_id) VALUES (1, 1);
INSERT INTO usuario_roles (usuario_id, rol_id) VALUES (2, 2);
INSERT INTO usuario_roles (usuario_id, rol_id) VALUES (2, 1);


-- Insertar sucursales
INSERT INTO sucursal (id, nombre, direccion) VALUES (1, 'Sucursal Centro', 'Av. Principal 123');
INSERT INTO sucursal (id, nombre, direccion) VALUES (2, 'Sucursal Norte', 'Calle Norte 456');
INSERT INTO sucursal (id, nombre, direccion) VALUES (3, 'Sucursal Sur', 'Avenida Sur 789');

-- Insertar productos
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (1, 'Martillo de Acero', 'Martillos', 'Stanley', 12990.00, 50);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (2, 'Martillo de Carpintero', 'Martillos', 'Truper', 15990.00, 30);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (3, 'Destornillador Phillips 6mm', 'Destornilladores', 'Truper', 5990.00, 75);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (4, 'Destornillador Plano 8mm', 'Destornilladores', 'Stanley', 5500.00, 60);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (5, 'Llave Inglesa 10"', 'Llaves', 'Bahco', 12990.00, 40);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (6, 'Llave Allen Set 10 piezas', 'Llaves', 'Truper', 8990.00, 70);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (7, 'Taladro Eléctrico 500W', 'Taladros', 'Bosch', 89990.00, 20);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (8, 'Taladro Percutor 800W', 'Taladros', 'Black & Decker', 109990.00, 15);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (9, 'Sierra Circular 7"', 'Sierras', 'Makita', 119990.00, 10);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (10, 'Sierra Caladora', 'Sierras', 'Bosch', 89990.00, 12);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (11, 'Lijadora Orbital', 'Lijadoras', 'Black & Decker', 49990.00, 18);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (12, 'Lijadora de Banda', 'Lijadoras', 'DeWalt', 79990.00, 7);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (13, 'Cemento Portland 25kg', 'Cemento', 'Lafarge', 3790.00, 150);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (14, 'Arena Fina 20kg', 'Arena', 'Constructor', 1990.00, 200);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (15, 'Ladrillos Rojo Común', 'Ladrillos', 'Cerámica del Sur', 350.00, 1000);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (16, 'Ladrillos Huecos', 'Ladrillos', 'Cerámica del Sur', 400.00, 800);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (17, 'Pintura Látex Blanca 1L', 'Pinturas', 'Sherwin Williams', 6990.00, 100);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (18, 'Barniz Transparente 1L', 'Barnices', 'Sayerlack', 12990.00, 50);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (19, 'Cerámicos Baño 30x30cm', 'Cerámicos', 'Porcelanite', 14990.00, 70);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (20, 'Casco de Seguridad Naranja', 'Casos', '3M', 10990.00, 35);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (21, 'Guantes de Trabajo Talla M', 'Guantes', 'Dexter', 3490.00, 80);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (22, 'Guantes Anti Cortes', 'Guantes', 'Ansell', 5490.00, 50);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (23, 'Lentes de Seguridad', 'Lentes de Seguridad', 'Uvex', 7990.00, 45);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (24, 'Accesorios Varios para Seguridad', 'Accesorios Varios', '3M', 3990.00, 100);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (25, 'Tornillos para Madera 3x25mm (100u)', 'Tornillos y Anclajes', 'Fischer', 5990.00, 120);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (26, 'Tornillos Autoperforantes 5x50mm (100u)', 'Tornillos y Anclajes', 'Fischer', 7990.00, 90);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (27, 'Adhesivo Epóxico 250ml', 'Fijaciones y Adhesivos', 'Loctite', 8990.00, 60);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (28, 'Silicona Transparente 300ml', 'Fijaciones y Adhesivos', 'Sika', 5990.00, 70);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (29, 'Multímetro Digital', 'Equipos de Medición', 'Fluke', 54990.00, 25);
INSERT INTO producto (id, nombre, categoria, marca, precio, stock) VALUES (30, 'Cinta Métrica 5m', 'Equipos de Medición', 'Stanley', 4990.00, 100);

-- Insertar producto_sucursal (relación)
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (1, 1);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (1, 2);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (2, 1);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (3, 1);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (3, 2);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (4, 1);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (5, 2);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (6, 1);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (7, 1);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (7, 3);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (8, 2);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (8, 3);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (9, 1);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (9, 2);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (10, 2);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (11, 1);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (12, 2);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (13, 1);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (13, 3);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (14, 2);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (15, 1);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (15, 2);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (16, 2);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (17, 1);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (18, 2);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (19, 1);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (19, 3);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (20, 2);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (21, 1);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (22, 2);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (23, 1);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (24, 2);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (25, 1);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (25, 2);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (26, 2);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (26, 3);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (27, 1);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (28, 2);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (29, 1);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (29, 3);
INSERT INTO producto_sucursal (producto_id, sucursal_id) VALUES (30, 2);

