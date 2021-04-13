--liquibase formatted sql

--changeset poputnikovv:CS003
CREATE TABLE operations
(
  id          INT          GENERATED ALWAYS AS IDENTITY,
  account_id  INT          NOT NULL,
  amount      DECIMAL      NOT NULL,
  type        VARCHAR(20)  NOT NULL,
  PRIMARY KEY(id),
  CONSTRAINT fk_customer_account FOREIGN KEY(account_id) REFERENCES customer_account(id)
);