package ru.hogwarts.repository;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long>{
}
