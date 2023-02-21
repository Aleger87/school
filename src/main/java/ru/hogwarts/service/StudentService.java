package ru.hogwarts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.model.Faculty;
import ru.hogwarts.model.Student;
import ru.hogwarts.repository.StudentRepository;

import java.util.*;

@Service
public class StudentService {
    Logger logger = LoggerFactory.getLogger(StudentService.class);
   private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student postStudent(Student student) {
        logger.info("Was invoked method for post student {}", student);
        return studentRepository.save(student);

    }


    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Student putStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudent(Long id) {
        //return studentRepository.findById(id).get();
        logger.info("Was invoked method for get student by id {}", id);
        try {
            return studentRepository.findById(id).get();
        } catch (Exception e) {
            new IllegalArgumentException("Not Found");
            logger.warn("There is not student with id {}", id );
        }
        return null;
    }

    public Collection<Student> getStudentsFilterByAge(int age) {
        logger.info("Was invoked method for get students filter by age {}", age);
        return studentRepository.findByAge(age);
    }

    public Collection<Student> getAllStudent() {
        logger.info("Was invoked method for get all students");
        return studentRepository.findAll();
    }

    public Collection<Student> getStudentsByAgeBetween(Integer min, Integer max) {
        logger.info("Was invoked method for get students by age between min {} and max {}" , min, max);
        return studentRepository.findByAgeBetween(min, max);
    }

    public Faculty getFacultyByStudent(long id) {
        //return studentRepository.findByIdStudent(id).getFaculty();
        logger.info("Was invoked method for get faculty by student id {}", id);
        return studentRepository.findFacultyByStudentId(id);
    }

    public Long getCountStudents() {
        logger.info("Was invoked method for get count students");
        return studentRepository.getCountStudents();
    }

    public Integer getAverageAge() {
        logger.info("Was invoked method for get average student");
        return studentRepository.getAverageAge();
    }

    public Collection<Student> getLastStudents(Integer countStudents) {
        logger.info("Was invoked method for get last students");
        return studentRepository.getLastStudents(countStudents);
    }
}
