--liquibase formatted sql

--changeset poputnikovv:CS002
CREATE TABLE customer_account
(
  id          INT          GENERATED ALWAYS AS IDENTITY,
  customer_id INT          NOT NULL,
  balance     DECIMAL      default 0,
  PRIMARY KEY(id),
  CONSTRAINT fk_customer FOREIGN KEY(customer_id) REFERENCES customer(id)
);