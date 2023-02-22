--liquibase formatted sql

--changeSet agerb:1
CREATE INDEX idx_name ON student (name);




