package ru.hogwarts.repository;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
