INSERT INTO t_user (country, firstname, lastname, password, role, username) VALUES ('Colombia', 'Miguel', 'Polo', '$2a$10$PZmoWzIl9YPjSmP8c11yb.WxZQyndtWKeShEuficgilEjVTrCbo1W', 'USER', 'mpolo');
INSERT INTO t_user (country, firstname, lastname, password, role, username) VALUES ('Colombia', 'Samuel', 'Kilombo', '$2a$10$PZmoWzIl9YPjSmP8c11yb.WxZQyndtWKeShEuficgilEjVTrCbo1W', 'ADMIN', 'ksamuel');

INSERT INTO category (name) VALUES ('ct1');
INSERT INTO category (name) VALUES ('ct12');


-- Insertar productos
INSERT INTO product (description, image_link, name, price, amount) VALUES ('de1', 'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/product-17-image-1-a7d462e3-2bed-4882-ae31-c80bc6b1f537.jpg', 'nm1', 90.0, 30);
INSERT INTO product (description, image_link, name, price, amount) VALUES ('de2', 'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/product-15-image-1-9d6423ba-2c84-4572-b85d-22e66c2274d3.jpg', 'nm2', 100.0, 40);
INSERT INTO product (description, image_link, name, price, amount) VALUES ('de3', 'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/product-13-image-1-2cb03936-a076-4c88-b086-aa3bc2d38c76.jpg', 'nm3', 110.0, 50);

-- Insertar categorías asociadas a los productos existentes
INSERT INTO categories (product_id, category_id) VALUES (1L, 1L);
INSERT INTO categories (product_id, category_id) VALUES (1L, 2L);
INSERT INTO categories (product_id, category_id) VALUES (2L, 1L);
INSERT INTO categories (product_id, category_id) VALUES (3L, 2L);
