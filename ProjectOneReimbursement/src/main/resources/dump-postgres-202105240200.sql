--
-- PostgreSQL database dump
--

-- Dumped from database version 10.16
-- Dumped by pg_dump version 10.16

-- Started on 2021-05-24 02:00:59

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 8 (class 2615 OID 16412)
-- Name: ers; Type: SCHEMA; Schema: -; Owner: rchoy1
--

CREATE SCHEMA ers;


ALTER SCHEMA ers OWNER TO rchoy1;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 203 (class 1259 OID 16476)
-- Name: ers_reimbursement; Type: TABLE; Schema: ers; Owner: rchoy1
--

CREATE TABLE ers.ers_reimbursement (
    reimb_id integer NOT NULL,
    reimb_amount numeric NOT NULL,
    reimb_submitted timestamp(0) without time zone NOT NULL,
    reimb_resolved timestamp(0) without time zone,
    reimb_description character varying(250),
    ers_users_id integer NOT NULL,
    reimb_resolver integer,
    reimb_status_id integer DEFAULT 1 NOT NULL,
    reimb_type_id integer NOT NULL
);


ALTER TABLE ers.ers_reimbursement OWNER TO rchoy1;

--
-- TOC entry 202 (class 1259 OID 16474)
-- Name: ers_reimbursement_reimb_id_seq; Type: SEQUENCE; Schema: ers; Owner: rchoy1
--

CREATE SEQUENCE ers.ers_reimbursement_reimb_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ers.ers_reimbursement_reimb_id_seq OWNER TO rchoy1;

--
-- TOC entry 3840 (class 0 OID 0)
-- Dependencies: 202
-- Name: ers_reimbursement_reimb_id_seq; Type: SEQUENCE OWNED BY; Schema: ers; Owner: rchoy1
--

ALTER SEQUENCE ers.ers_reimbursement_reimb_id_seq OWNED BY ers.ers_reimbursement.reimb_id;


--
-- TOC entry 197 (class 1259 OID 16419)
-- Name: ers_reimbursement_status; Type: TABLE; Schema: ers; Owner: rchoy1
--

CREATE TABLE ers.ers_reimbursement_status (
    reimb_status_id integer DEFAULT 1 NOT NULL,
    reimb_status character varying(10) NOT NULL
);


ALTER TABLE ers.ers_reimbursement_status OWNER TO rchoy1;

--
-- TOC entry 198 (class 1259 OID 16422)
-- Name: ers_reimbursement_type; Type: TABLE; Schema: ers; Owner: rchoy1
--

CREATE TABLE ers.ers_reimbursement_type (
    reimb_type_id integer DEFAULT 1 NOT NULL,
    reimb_type character varying(10) NOT NULL
);


ALTER TABLE ers.ers_reimbursement_type OWNER TO rchoy1;

--
-- TOC entry 199 (class 1259 OID 16425)
-- Name: ers_user_roles; Type: TABLE; Schema: ers; Owner: rchoy1
--

CREATE TABLE ers.ers_user_roles (
    ers_user_role_id integer NOT NULL,
    user_role character varying(10) NOT NULL
);


ALTER TABLE ers.ers_user_roles OWNER TO rchoy1;

--
-- TOC entry 201 (class 1259 OID 16463)
-- Name: ers_users; Type: TABLE; Schema: ers; Owner: rchoy1
--

CREATE TABLE ers.ers_users (
    ers_users_id integer NOT NULL,
    ers_username character varying(50) NOT NULL,
    ers_password character varying(50) NOT NULL,
    user_first_name character varying(100) NOT NULL,
    user_last_name character varying(100) NOT NULL,
    user_email character varying(150) NOT NULL,
    ers_user_role_id integer NOT NULL
);


ALTER TABLE ers.ers_users OWNER TO rchoy1;

--
-- TOC entry 200 (class 1259 OID 16461)
-- Name: ers_users_ers_users_id_seq; Type: SEQUENCE; Schema: ers; Owner: rchoy1
--

CREATE SEQUENCE ers.ers_users_ers_users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ers.ers_users_ers_users_id_seq OWNER TO rchoy1;

--
-- TOC entry 3841 (class 0 OID 0)
-- Dependencies: 200
-- Name: ers_users_ers_users_id_seq; Type: SEQUENCE OWNED BY; Schema: ers; Owner: rchoy1
--

ALTER SEQUENCE ers.ers_users_ers_users_id_seq OWNED BY ers.ers_users.ers_users_id;


--
-- TOC entry 3689 (class 2604 OID 16479)
-- Name: ers_reimbursement reimb_id; Type: DEFAULT; Schema: ers; Owner: rchoy1
--

ALTER TABLE ONLY ers.ers_reimbursement ALTER COLUMN reimb_id SET DEFAULT nextval('ers.ers_reimbursement_reimb_id_seq'::regclass);


--
-- TOC entry 3688 (class 2604 OID 16466)
-- Name: ers_users ers_users_id; Type: DEFAULT; Schema: ers; Owner: rchoy1
--

ALTER TABLE ONLY ers.ers_users ALTER COLUMN ers_users_id SET DEFAULT nextval('ers.ers_users_ers_users_id_seq'::regclass);


--
-- TOC entry 3834 (class 0 OID 16476)
-- Dependencies: 203
-- Data for Name: ers_reimbursement; Type: TABLE DATA; Schema: ers; Owner: rchoy1
--

INSERT INTO ers.ers_reimbursement VALUES (2, 12323, '2021-05-23 16:37:35', NULL, 'sadfasdfasdfasd', 1, 3, 2, 1);
INSERT INTO ers.ers_reimbursement VALUES (3, 100000, '2021-05-23 16:40:47', NULL, 'sfdsafsadf', 1, 3, 2, 1);


--
-- TOC entry 3828 (class 0 OID 16419)
-- Dependencies: 197
-- Data for Name: ers_reimbursement_status; Type: TABLE DATA; Schema: ers; Owner: rchoy1
--

INSERT INTO ers.ers_reimbursement_status VALUES (1, 'PENDING');
INSERT INTO ers.ers_reimbursement_status VALUES (2, 'APPROVED');
INSERT INTO ers.ers_reimbursement_status VALUES (3, 'DENIED');


--
-- TOC entry 3829 (class 0 OID 16422)
-- Dependencies: 198
-- Data for Name: ers_reimbursement_type; Type: TABLE DATA; Schema: ers; Owner: rchoy1
--

INSERT INTO ers.ers_reimbursement_type VALUES (1, 'LODGING');
INSERT INTO ers.ers_reimbursement_type VALUES (2, 'TRAVEL');
INSERT INTO ers.ers_reimbursement_type VALUES (3, 'FOOD');
INSERT INTO ers.ers_reimbursement_type VALUES (4, 'OTHER');


--
-- TOC entry 3830 (class 0 OID 16425)
-- Dependencies: 199
-- Data for Name: ers_user_roles; Type: TABLE DATA; Schema: ers; Owner: rchoy1
--

INSERT INTO ers.ers_user_roles VALUES (1, 'EMPLOYEE');
INSERT INTO ers.ers_user_roles VALUES (2, 'MANAGER');


--
-- TOC entry 3832 (class 0 OID 16463)
-- Dependencies: 201
-- Data for Name: ers_users; Type: TABLE DATA; Schema: ers; Owner: rchoy1
--

INSERT INTO ers.ers_users VALUES (2, 'bigBird', 'pass2', 'Bob', 'George', 'BG77@gmail.com', 1);
INSERT INTO ers.ers_users VALUES (3, 'SuperKev', 'pass3', 'Kevin', 'Jay', 'kev55@gmail.com', 2);
INSERT INTO ers.ers_users VALUES (1, 'rchoy1', 'pass1', 'Ryan', 'Choy', 'rchoy@gmail.com', 1);


--
-- TOC entry 3842 (class 0 OID 0)
-- Dependencies: 202
-- Name: ers_reimbursement_reimb_id_seq; Type: SEQUENCE SET; Schema: ers; Owner: rchoy1
--

SELECT pg_catalog.setval('ers.ers_reimbursement_reimb_id_seq', 3, true);


--
-- TOC entry 3843 (class 0 OID 0)
-- Dependencies: 200
-- Name: ers_users_ers_users_id_seq; Type: SEQUENCE SET; Schema: ers; Owner: rchoy1
--

SELECT pg_catalog.setval('ers.ers_users_ers_users_id_seq', 3, true);


--
-- TOC entry 3702 (class 2606 OID 16481)
-- Name: ers_reimbursement ers_reimbursement_pk; Type: CONSTRAINT; Schema: ers; Owner: rchoy1
--

ALTER TABLE ONLY ers.ers_reimbursement
    ADD CONSTRAINT ers_reimbursement_pk PRIMARY KEY (reimb_id);


--
-- TOC entry 3692 (class 2606 OID 16445)
-- Name: ers_reimbursement_status ers_reimbursement_status_pk; Type: CONSTRAINT; Schema: ers; Owner: rchoy1
--

ALTER TABLE ONLY ers.ers_reimbursement_status
    ADD CONSTRAINT ers_reimbursement_status_pk PRIMARY KEY (reimb_status_id);


--
-- TOC entry 3694 (class 2606 OID 16451)
-- Name: ers_reimbursement_type ers_reimbursement_type_pk; Type: CONSTRAINT; Schema: ers; Owner: rchoy1
--

ALTER TABLE ONLY ers.ers_reimbursement_type
    ADD CONSTRAINT ers_reimbursement_type_pk PRIMARY KEY (reimb_type_id);


--
-- TOC entry 3696 (class 2606 OID 16453)
-- Name: ers_user_roles ers_user_roles_pk; Type: CONSTRAINT; Schema: ers; Owner: rchoy1
--

ALTER TABLE ONLY ers.ers_user_roles
    ADD CONSTRAINT ers_user_roles_pk PRIMARY KEY (ers_user_role_id);


--
-- TOC entry 3698 (class 2606 OID 16468)
-- Name: ers_users ers_users_pk; Type: CONSTRAINT; Schema: ers; Owner: rchoy1
--

ALTER TABLE ONLY ers.ers_users
    ADD CONSTRAINT ers_users_pk PRIMARY KEY (ers_users_id);


--
-- TOC entry 3700 (class 2606 OID 16470)
-- Name: ers_users ers_users_un; Type: CONSTRAINT; Schema: ers; Owner: rchoy1
--

ALTER TABLE ONLY ers.ers_users
    ADD CONSTRAINT ers_users_un UNIQUE (ers_username, user_email);


--
-- TOC entry 3704 (class 2606 OID 16503)
-- Name: ers_reimbursement ers_reimbursement_status_fk; Type: FK CONSTRAINT; Schema: ers; Owner: rchoy1
--

ALTER TABLE ONLY ers.ers_reimbursement
    ADD CONSTRAINT ers_reimbursement_status_fk FOREIGN KEY (reimb_status_id) REFERENCES ers.ers_reimbursement_status(reimb_status_id);


--
-- TOC entry 3705 (class 2606 OID 16508)
-- Name: ers_reimbursement ers_reimbursement_type_fk; Type: FK CONSTRAINT; Schema: ers; Owner: rchoy1
--

ALTER TABLE ONLY ers.ers_reimbursement
    ADD CONSTRAINT ers_reimbursement_type_fk FOREIGN KEY (reimb_type_id) REFERENCES ers.ers_reimbursement_type(reimb_type_id);


--
-- TOC entry 3706 (class 2606 OID 16518)
-- Name: ers_reimbursement ers_users_fk_auth; Type: FK CONSTRAINT; Schema: ers; Owner: rchoy1
--

ALTER TABLE ONLY ers.ers_reimbursement
    ADD CONSTRAINT ers_users_fk_auth FOREIGN KEY (ers_users_id) REFERENCES ers.ers_users(ers_users_id);


--
-- TOC entry 3703 (class 2606 OID 16513)
-- Name: ers_users user_roles_fk; Type: FK CONSTRAINT; Schema: ers; Owner: rchoy1
--

ALTER TABLE ONLY ers.ers_users
    ADD CONSTRAINT user_roles_fk FOREIGN KEY (ers_user_role_id) REFERENCES ers.ers_user_roles(ers_user_role_id);


-- Completed on 2021-05-24 02:01:03

--
-- PostgreSQL database dump complete
--

