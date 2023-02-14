--liquibase formatted sql

--changeSet agerb:1

CREATE TABLE IF NOT EXISTS public.faculty
(
    id_faculty bigint NOT NULL,
    color character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT faculty_pkey PRIMARY KEY (id_faculty)
)

--changeSet agerb:2
CREATE INDEX faculty_by_idx_name_and_color ON faculty (name, color);