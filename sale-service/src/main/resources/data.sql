INSERT INTO PRODUCT (id, name, price) VALUES
('42a48c09-bf75-45de-a2df-8b8def77d13e', 'Smartphone Samsung M51', 1800);

INSERT INTO CUSTOMER (id, name, email) VALUES
('85343be7-7e60-4e1d-9745-531e2b1cb497', 'Customer1', 'customer1@gmail.com');

INSERT INTO SALESPERSON (id, name) VALUES
('42abaf58-2a9d-4eeb-8b65-2b2ca733f3fb', 'Salesperson1');

INSERT INTO SALE (id, customer_id, salesperson_id, date, amount) VALUES
('28e96b4f-957c-4d77-9725-6ab22d49e5d3', '85343be7-7e60-4e1d-9745-531e2b1cb497', '42abaf58-2a9d-4eeb-8b65-2b2ca733f3fb', '2021-06-24', 1800);

INSERT INTO PRODUCT_SALE (sale_id, product_id) VALUES
('28e96b4f-957c-4d77-9725-6ab22d49e5d3', '42a48c09-bf75-45de-a2df-8b8def77d13e');
