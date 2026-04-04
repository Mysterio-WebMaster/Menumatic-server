--
-- PostgreSQL database dump
--

\restrict IC7mYP6swfK7gjJ750BQUdkqaESwy5EbWaREE41CIgAxZ7faxqhrjOIb99AcQUG

-- Dumped from database version 18.2
-- Dumped by pg_dump version 18.2

-- Started on 2026-03-30 22:43:58

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 5005 (class 0 OID 16445)
-- Dependencies: 219
-- Data for Name: menu; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.menu (item_id, item_category, item_name, item_price, item_cuisine) FROM stdin;
1	Test	Test	44.99	Test
\.


--
-- TOC entry 5012 (class 0 OID 0)
-- Dependencies: 220
-- Name: menu_item_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.menu_item_id_seq', 1, true);


-- Completed on 2026-03-30 22:43:58

--
-- PostgreSQL database dump complete
--

\unrestrict IC7mYP6swfK7gjJ750BQUdkqaESwy5EbWaREE41CIgAxZ7faxqhrjOIb99AcQUG

