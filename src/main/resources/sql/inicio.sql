--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.16
-- Dumped by pg_dump version 9.3.16
-- Started on 2017-10-06 20:18:23

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1961 (class 1262 OID 16394)
-- Name: chamadodb; Type: DATABASE; Schema: -; Owner: user
--

CREATE DATABASE chamadodb WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';


ALTER DATABASE chamadodb OWNER TO "user";

\connect chamadodb

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 8 (class 2615 OID 16395)
-- Name: chamado; Type: SCHEMA; Schema: -; Owner: user
--

CREATE SCHEMA chamado;


ALTER SCHEMA chamado OWNER TO "user";

--
-- TOC entry 1 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1964 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = chamado, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 176 (class 1259 OID 16407)
-- Name: chamado; Type: TABLE; Schema: chamado; Owner: user; Tablespace: 
--

CREATE TABLE chamado (
    id integer NOT NULL,
    numero integer,
    assunto character varying(50),
    descricao text,
    data_abertura date,
    sistema character varying(20),
    id_solicitante integer,
    situacao character varying(20),
    observacao text,
    tipo character varying(30),
    data_fechamento date,
    hora_abertura time without time zone,
    hora_fechamento time without time zone
);


ALTER TABLE chamado.chamado OWNER TO "user";

--
-- TOC entry 177 (class 1259 OID 16415)
-- Name: intervencao; Type: TABLE; Schema: chamado; Owner: user; Tablespace: 
--

CREATE TABLE intervencao (
    id integer NOT NULL,
    id_chamado integer NOT NULL,
    data_hora timestamp without time zone,
    descricao text,
    observacao text
);


ALTER TABLE chamado.intervencao OWNER TO "user";

--
-- TOC entry 175 (class 1259 OID 16405)
-- Name: seq_id_chamado; Type: SEQUENCE; Schema: chamado; Owner: user
--

CREATE SEQUENCE seq_id_chamado
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE chamado.seq_id_chamado OWNER TO "user";

--
-- TOC entry 174 (class 1259 OID 16403)
-- Name: seq_id_intervencao; Type: SEQUENCE; Schema: chamado; Owner: user
--

CREATE SEQUENCE seq_id_intervencao
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE chamado.seq_id_intervencao OWNER TO "user";

--
-- TOC entry 173 (class 1259 OID 16401)
-- Name: seq_id_usuario; Type: SEQUENCE; Schema: chamado; Owner: user
--

CREATE SEQUENCE seq_id_usuario
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE chamado.seq_id_usuario OWNER TO "user";

--
-- TOC entry 172 (class 1259 OID 16396)
-- Name: usuario; Type: TABLE; Schema: chamado; Owner: user; Tablespace: 
--

CREATE TABLE usuario (
    id integer NOT NULL,
    nome character varying(30) NOT NULL,
    setor character varying(30),
    ramal character varying(15)
);


ALTER TABLE chamado.usuario OWNER TO "user";

--
-- TOC entry 1955 (class 0 OID 16407)
-- Dependencies: 176
-- Data for Name: chamado; Type: TABLE DATA; Schema: chamado; Owner: user
--

INSERT INTO chamado.chamado (id, numero, assunto, descricao, data_abertura, sistema, id_solicitante, situacao, observacao, tipo, data_fechamento, hora_abertura, hora_fechamento) VALUES (2, 62315, NULL, 'Erro ao salvar proposta.
Segue Exemplo', '2017-10-03', 'CADASTRO', 10, 'FECHADO', NULL, 'REQUISICAO', '2017-10-05', '18:24:00', '18:35:00');
INSERT INTO chamado.chamado (id, numero, assunto, descricao, data_abertura, sistema, id_solicitante, situacao, observacao, tipo, data_fechamento, hora_abertura, hora_fechamento) VALUES (3, 64123, NULL, 'No aditamento da Cédula de Crédito Bancário nº 57851/1 - Posto Ajuruteua, (em anexo) o ítem 16. avalistas, está em branco e na folha final também não constam os nomes e assinaturas dos avalistas/conjuges. 

Anexo também a Cédula de Crédito Bancário Cheque Empresarial nº 39638, que deu origem a confissão de dívida.', '2017-09-28', 'CADASTRO', NULL, 'ABERTO', NULL, 'REQUISICAO', NULL, '18:58:00', NULL);
INSERT INTO chamado.chamado (id, numero, assunto, descricao, data_abertura, sistema, id_solicitante, situacao, observacao, tipo, data_fechamento, hora_abertura, hora_fechamento) VALUES (4, 65102, NULL, 'Favor verificar o erro ocorrido na contratação de Cheque Especial do cliente Manoel Paiva de Sousa (CPF: 036.220.612-00), conforme anexo. Destacamos que em nossos testes não encontramos erro na consulta de limites do referido cliente (telas também em anexo)

Ressalto que precisamos de um retorno urgente, considerando o impacto na comercialização dos produtos, nas agências.', '2017-10-03', 'CADASTRO', NULL, 'ABERTO', NULL, 'REQUISICAO', NULL, '18:13:00', NULL);
INSERT INTO chamado.chamado (id, numero, assunto, descricao, data_abertura, sistema, id_solicitante, situacao, observacao, tipo, data_fechamento, hora_abertura, hora_fechamento) VALUES (6, 51472, NULL, NULL, '2017-10-03', 'GRISCO', 10, 'FECHADO', NULL, 'REQUISICAO', '2017-10-05', '18:24:00', '18:35:00');


--
-- TOC entry 1956 (class 0 OID 16415)
-- Dependencies: 177
-- Data for Name: intervencao; Type: TABLE DATA; Schema: chamado; Owner: user
--



--
-- TOC entry 1965 (class 0 OID 0)
-- Dependencies: 175
-- Name: seq_id_chamado; Type: SEQUENCE SET; Schema: chamado; Owner: user
--

SELECT pg_catalog.setval('seq_id_chamado', 6, true);


--
-- TOC entry 1966 (class 0 OID 0)
-- Dependencies: 174
-- Name: seq_id_intervencao; Type: SEQUENCE SET; Schema: chamado; Owner: user
--

SELECT pg_catalog.setval('seq_id_intervencao', 1, false);


--
-- TOC entry 1967 (class 0 OID 0)
-- Dependencies: 173
-- Name: seq_id_usuario; Type: SEQUENCE SET; Schema: chamado; Owner: user
--

SELECT pg_catalog.setval('seq_id_usuario', 40, true);


--
-- TOC entry 1951 (class 0 OID 16396)
-- Dependencies: 172
-- Data for Name: usuario; Type: TABLE DATA; Schema: chamado; Owner: user
--

INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (10, 'Usuario comercial', 'Comercial', '120');
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (11, 'Usuario comercial', 'Comercial', '120');
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (12, 'Teste usuario', 'teste', '123');
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (13, 'Teste usuario 2', 'setr2', NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (14, 'Teste usuario 3', NULL, NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (15, 'Teste usuario 4', NULL, NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (16, 'Teste usuario 5', NULL, NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (17, 'Teste usuario 6', NULL, NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (18, 'Teste usuario 7', NULL, NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (19, 'Teste usuario 7', NULL, NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (20, 'teste', NULL, NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (21, 'Lismar', 'producao', NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (22, 'Teste usuario', 'setr2', '123');
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (23, 'Teste usuario', NULL, NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (24, 'Teste usuario', NULL, NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (25, 'asd', NULL, NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (26, 'asdas', 'asdasd', 'asdasd');
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (27, 'TEste 2', 'setor', NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (28, 'asd', NULL, NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (29, 'tra', NULL, NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (30, 'agjkl', NULL, NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (31, 'abc', NULL, NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (32, 'adfg', NULL, NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (33, 'asfg', NULL, NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (34, 'asdasd', NULL, NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (35, 'sdfgsdfg', 'dfg', 'dgfdfg');
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (36, 'dfsdfg', NULL, NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (37, 'Teste usuario', NULL, NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (38, 'sdfsdf', NULL, NULL);
INSERT INTO chamado.usuario (id, nome, setor, ramal) VALUES (39, 'Nome corrigido', 'Setor 1', NULL);


CREATE TABLE chamado.lista_valor
(
  id integer NOT NULL,
  codigo character(40),
  descricao character varying(40),
  CONSTRAINT pk_tipo_valor PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE chamado.lista_valor
  OWNER TO postgres;

--
-- TOC entry 1963 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2017-10-06 20:18:23

--
-- PostgreSQL database dump complete
--

