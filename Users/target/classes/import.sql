INSERT INTO role (name) VALUES ('admin');
INSERT INTO role (name) VALUES ('editor');

INSERT INTO users (username, password, email) values ('user1', 'pass1', 'email1');
INSERT INTO users (username, password, email) values ('user2', 'pass2', 'email2');
INSERT INTO users (username, password, email) values ('user3', 'pass3', 'email3');

INSERT INTO roles (user_id, role_id) VALUES (1L, 1L);
INSERT INTO roles (user_id, role_id) VALUES (2L, 1L);
INSERT INTO roles (user_id, role_id) VALUES (2L, 2L);
INSERT INTO roles (user_id, role_id) VALUES (3L, 2L);