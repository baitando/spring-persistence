CREATE TABLE customer(
  ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
  FIRST_NAME VARCHAR(255) NOT NULL,
  LAST_NAME VARCHAR(255) NOT NULL,
  PRIMARY KEY (ID)
);