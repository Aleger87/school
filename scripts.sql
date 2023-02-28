select * from student where age >= 10 and age <= 15;
select name from student;
select * from student where name like '%Але%';
select * from student where age < student.id_student;
select * from student order by age;
select * from faculty where id_faculty in (select faculty_id from student where name like '%Але%');
select avg(age) from student;
select * from Student group by id_student  having id_student <= 3;