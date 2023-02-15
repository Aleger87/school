--liquibase formatted sql

--changeSet agerb:1
CREATE INDEX faculty_by_idx_name_and_color ON faculty (name, color);