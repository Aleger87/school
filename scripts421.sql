/*
- Возраст студента не может быть меньше 16 лет.
- Имена студентов должны быть уникальными и не равны нулю.
- Пара “значение названия” - “цвет факультета” должна быть уникальной.
- При создании студента без возраста ему автоматически должно присваиваться 20 лет.
*/
ALTER TABLE student
    ADD CONSTRAINT age_constraint CHECK (age > 16);

ALTER TABLE student
ALTER COLUMN name SET NOT NULL;

ALTER TABLE student
    ADD CONSTRAINT nickname_unique UNIQUE (name);

ALTER TABLE faculty
    ADD CONSTRAINT name_color_unique UNIQUE (name, color);

ALTER TABLE faculty
    ADD CONSTRAINT login_pass_unique UNIQUE (name, color);

ALTER TABLE faculty
    DROP CONSTRAINT login_pass_unique;

ALTER TABLE student
   ALTER COLUMN age SET DEFAULT 20;

