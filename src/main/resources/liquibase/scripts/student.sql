--liquibase formatted sql

--changeSet agerb:1
CREATE TABLE IF NOT EXISTS public.student
(
    id_student bigint NOT NULL PRIMARY KEY,
    age integer NOT NULL DEFAULT 20,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    faculty_id bigint
    )
--changeSet agerb:2
CREATE INDEX student_by_idx_name ON student (name);




