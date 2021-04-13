--liquibase formatted sql

--changeset poputnikovv:CS001
CREATE TABLE customer
(
  id          INT          GENERATED ALWAYS AS IDENTITY,
  full_name   VARCHAR(255) NOT NULL,
  PRIMARY KEY(id)
);