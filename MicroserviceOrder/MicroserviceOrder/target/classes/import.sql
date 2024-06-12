INSERT INTO item (product_id, amount) VALUES (1L, 21);
INSERT INTO item (product_id, amount) VALUES (2L, 15);
INSERT INTO item (product_id, amount) VALUES (3L, 12);

INSERT INTO order_table (client_id, str_date, str_state) VALUES (1L, 'date1', 'Send');
INSERT INTO order_table (client_id, str_date, str_state) VALUES (2L, 'date2', 'OnHold');

INSERT INTO order_table_items (items_item_id, order_order_id) VALUES (1L, 2L);