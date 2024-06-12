INSERT INTO t_user (country, firstname, lastname, password, role, username) VALUES ('parasernombrada', 'quenecesita', 'llegarhastaesteatributo', '$2a$10$PZmoWzIl9YPjSmP8c11yb.WxZQyndtWKeShEuficgilEjVTrCbo1W', 'USER', 'user');
INSERT INTO t_user (country, firstname, lastname, password, role, username) VALUES ('parasernombrada', 'quenecesita', 'llegarhastaesteatributo', '$2a$10$PZmoWzIl9YPjSmP8c11yb.WxZQyndtWKeShEuficgilEjVTrCbo1W', 'ADMIN', 'admin');

INSERT INTO category (name) VALUES ('Prenda');
INSERT INTO category (name) VALUES ('Accesorio');


-- Insertar productos
INSERT INTO product (description, image_link, name, price, amount) VALUES ('Sin descripción.', 'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/product-10-image-3-de7e5e32-6e74-463c-9802-e00be57ef4a2.jpg', 'Bufanda turquesa ', 140000.0, 30);
INSERT INTO product (description, image_link, name, price, amount) VALUES (' Esta ruana beige con azul oscuro es una verdadera obra de arte. Confeccionada a mano en telar manual horizontal, cada hilo de seda devanado, burdo y chape ha sido cuidadosamente tejido para crear un patrón único y llamativo que atrae todas las miradas.', 'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/PhotoRoom_018_20230109_111112_compressed-d1090d71-b745-4cca-bfdf-180dfcf5d56f.jpg', 'Ruana beige con azul oscuro 1CD0', 380000.0, 40);
INSERT INTO product (description, image_link, name, price, amount) VALUES ('Aretes con hilos y cortezas de capullos de seda 100% natural', 'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/IMG_20240223_121702-8d263f7f-fa97-445f-ad96-d57d02ca0e98.jpg', 'Aretes hilo negro', 35000.0, 2);


-- Insertar categorías asociadas a los productos existentes
INSERT INTO categories (product_id, category_id) VALUES (1L, 1L);
INSERT INTO categories (product_id, category_id) VALUES (1L, 2L);
INSERT INTO categories (product_id, category_id) VALUES (2L, 1L);
INSERT INTO categories (product_id, category_id) VALUES (3L, 2L);