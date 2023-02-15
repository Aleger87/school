--liquibase formatted sql

--changeSet agerb:2
CREATE INDEX student_by_idx_name ON student (name);




