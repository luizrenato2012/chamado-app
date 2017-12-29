--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.16
-- Dumped by pg_dump version 9.3.16
-- Started on 2017-12-29 13:22:35

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = chamado, pg_catalog;




SELECT pg_catalog.setval('seq_id_chamado', 6, true);


--
-- TOC entry 1976 (class 0 OID 0)
-- Dependencies: 174
-- Name: seq_id_intervencao; Type: SEQUENCE SET; Schema: chamado; Owner: user
--

SELECT pg_catalog.setval('seq_id_intervencao', 1, false);


--
-- TOC entry 1977 (class 0 OID 0)
-- Dependencies: 178
-- Name: seq_id_lista_valor; Type: SEQUENCE SET; Schema: chamado; Owner: user
--

SELECT pg_catalog.setval('seq_id_lista_valor', 10, true);


--
-- TOC entry 1978 (class 0 OID 0)
-- Dependencies: 173
-- Name: seq_id_usuario; Type: SEQUENCE SET; Schema: chamado; Owner: user
--

SELECT pg_catalog.setval('seq_id_usuario', 40, true);


--
-- TOC entry 1962 (class 0 OID 16396)
-- Dependencies: 172
-- Data for Name: usuario; Type: TABLE DATA; Schema: chamado; Owner: user
--

INSERT INTO usuario VALUES (10, 'Usuario comercial', 'Comercial', '120');
INSERT INTO usuario VALUES (11, 'Usuario comercial', 'Comercial', '120');
INSERT INTO usuario VALUES (12, 'Teste usuario', 'teste', '123');
INSERT INTO usuario VALUES (13, 'Teste usuario 2', 'setr2', NULL);
INSERT INTO usuario VALUES (14, 'Teste usuario 3', NULL, NULL);
INSERT INTO usuario VALUES (15, 'Teste usuario 4', NULL, NULL);
INSERT INTO usuario VALUES (16, 'Teste usuario 5', NULL, NULL);
INSERT INTO usuario VALUES (17, 'Teste usuario 6', NULL, NULL);
INSERT INTO usuario VALUES (18, 'Teste usuario 7', NULL, NULL);
INSERT INTO usuario VALUES (19, 'Teste usuario 7', NULL, NULL);
INSERT INTO usuario VALUES (20, 'teste', NULL, NULL);
INSERT INTO usuario VALUES (21, 'Lismar', 'producao', NULL);
INSERT INTO usuario VALUES (22, 'Teste usuario', 'setr2', '123');
INSERT INTO usuario VALUES (23, 'Teste usuario', NULL, NULL);
INSERT INTO usuario VALUES (24, 'Teste usuario', NULL, NULL);
INSERT INTO usuario VALUES (25, 'asd', NULL, NULL);
INSERT INTO usuario VALUES (26, 'asdas', 'asdasd', 'asdasd');
INSERT INTO usuario VALUES (27, 'TEste 2', 'setor', NULL);
INSERT INTO usuario VALUES (28, 'asd', NULL, NULL);
INSERT INTO usuario VALUES (29, 'tra', NULL, NULL);
INSERT INTO usuario VALUES (30, 'agjkl', NULL, NULL);
INSERT INTO usuario VALUES (31, 'abc', NULL, NULL);
INSERT INTO usuario VALUES (32, 'adfg', NULL, NULL);
INSERT INTO usuario VALUES (33, 'asfg', NULL, NULL);
INSERT INTO usuario VALUES (34, 'asdasd', NULL, NULL);
INSERT INTO usuario VALUES (35, 'sdfgsdfg', 'dfg', 'dgfdfg');
INSERT INTO usuario VALUES (36, 'dfsdfg', NULL, NULL);
INSERT INTO usuario VALUES (37, 'Teste usuario', NULL, NULL);
INSERT INTO usuario VALUES (38, 'sdfsdf', NULL, NULL);
INSERT INTO usuario VALUES (39, 'Nome corrigido', 'Setor 1', NULL);


-- Completed on 2017-12-29 13:22:36

--
-- PostgreSQL database dump complete
--

