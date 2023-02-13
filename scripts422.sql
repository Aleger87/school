/*
Описание структуры: у каждого человека есть машина.
Причем несколько человек могут пользоваться одной машиной.
У каждого человека есть имя, возраст и признак того, что у него есть права (или их нет).
У каждой машины есть марка, модель и стоимость. Также не забудьте добавить таблицам первичные ключи и связать их.
*/
CREATE TABLE cars
(
    id          INTEGER PRIMARY KEY,
    brand        VARCHAR(100) NOT NULL,
    model        VARCHAR(100),
    price NUMERIC(10,2)
);


CREATE TABLE people
(
    id          INTEGER PRIMARY KEY,
    name        TEXT NOT NULL,
    age         INTEGER CHECK ( age > 18 ),
    certificate BOOLEAN,
    car_id INTEGER REFERENCES cars (id)
);

