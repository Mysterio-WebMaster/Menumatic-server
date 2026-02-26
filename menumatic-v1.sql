--
-- PostgreSQL database dump
--

\restrict UXFillzJzPVdmE9cEqpJOPzWScFbkrhuAYSLTD2EIEqaKZx2m54I8MGanyndb65

-- Dumped from database version 18.2
-- Dumped by pg_dump version 18.2

-- Started on 2026-02-24 22:15:49

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
-- TOC entry 5013 (class 1262 OID 16388)
-- Name: menumatic; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE menumatic WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_India.1252';


ALTER DATABASE menumatic OWNER TO postgres;

\unrestrict UXFillzJzPVdmE9cEqpJOPzWScFbkrhuAYSLTD2EIEqaKZx2m54I8MGanyndb65
\connect menumatic
\restrict UXFillzJzPVdmE9cEqpJOPzWScFbkrhuAYSLTD2EIEqaKZx2m54I8MGanyndb65

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
-- TOC entry 5007 (class 0 OID 16401)
-- Dependencies: 220
-- Data for Name: menu; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.menu (item_id, item_category, item_name, item_price) VALUES (1, 'Test Category', 'Test Name', 1052.96);


--
-- TOC entry 5016 (class 0 OID 0)
-- Dependencies: 219
-- Name: menu_item_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.menu_item_id_seq', 1, true);


-- Completed on 2026-02-24 22:15:49

--
-- PostgreSQL database dump complete
--

\unrestrict UXFillzJzPVdmE9cEqpJOPzWScFbkrhuAYSLTD2EIEqaKZx2m54I8MGanyndb65

