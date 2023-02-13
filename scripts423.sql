/*
Составить первый JOIN-запрос, чтобы получить информацию обо всех студентах
(достаточно получить только имя и возраст студента) школы Хогвартс вместе с названиями факультетов.

Составить второй JOIN-запрос, чтобы получить только тех студентов, у которых есть аватарки
*/
SELECT name, age, (select name from faculty where id_faculty = student.faculty_id) as faculty FROM student;

SELECT student.name, student.age, f.name as faculty
FROM student
INNER JOIN faculty f on f.id_faculty = student.faculty_id;


SELECT * FROM student WHERE id_student in (SELECT student_id_student from avatar);

SELECT *, a.student_id_student
FROM student
INNER JOIN avatar a on student.id_student = a.student_id_student