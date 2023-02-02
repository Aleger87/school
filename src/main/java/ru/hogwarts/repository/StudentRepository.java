package ru.hogwarts.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.model.Faculty;
import ru.hogwarts.model.Student;

import java.util.Collection;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public Collection<Student> findByAgeBetween(Integer mim, Integer max);

    public Student findByIdStudent(long student);

    public Collection<Student> findByAge(int age);

    @Query("select a.faculty from Student a where a.idStudent = :id")
    public Faculty findFacultyByStudentId(@Param("id") long id);

    @Query(value = "select * from Student  where faculty_id = :id", nativeQuery = true)
    Collection<Student> findStudentByFacultyId(long id);
}
