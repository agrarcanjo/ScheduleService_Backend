
CREATE DATABASE postgres
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;

COMMENT ON DATABASE postgres
  IS 'default administrative connection database';


-- DROP DATABASE minhasfinancas;

CREATE SCHEMA belezaBrasileira;

CREATE TABLE belezaBrasileira.address
(
  id_address bigserial NOT NULL PRIMARY KEY,
  nome character varying(150),
  email character varying(100),
  senha character varying(20),
  data_cadastro date default now()
);

CREATE TABLE belezaBrasileira.person
(
  id bigserial NOT NULL PRIMARY KEY ,
  descricao character varying(100) NOT NULL,
  mes integer NOT NULL,
  ano integer NOT NULL,
  valor numeric(16,2),
  tipo character varying(20),
  status character varying(20),
  id_usuario bigint REFERENCES financas.usuario (id),
  data_cadastro date default now()
);


CREATE TABLE belezaBrasileira.schedulePerson (
  id_person bigserial NOT NULL,
  id_schedule bigserial NOT NULL,
  PRIMARY KEY (id_person,id_schedule),
  KEY id_person (id_person),
  CONSTRAINT person_schedule_1
   FOREIGN KEY (id_person) REFERENCES person (id_person),
  CONSTRAINT person_schedule_2
   FOREIGN KEY (id_schedule) REFERENCES schedule (id_schedule)
);
