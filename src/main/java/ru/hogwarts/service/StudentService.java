package ru.hogwarts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.model.Faculty;
import ru.hogwarts.model.Student;
import ru.hogwarts.repository.StudentRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {
   private Logger logger = LoggerFactory.getLogger(StudentService.class);
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

    public Collection<String> getStudentsByFirstChar1(Character firstChar) {
        logger.info("Was invoked method for get Students By FirstChar1");
        List<String> students = new ArrayList<>(studentRepository.getStudentsByFirstChar(firstChar));
        return students.stream().map(s -> {
            return s.toUpperCase();
        }).collect(Collectors.toList());



    }

    public Collection<String> getStudentsByFirstChar2(Character firstChar) {

        logger.info("Was invoked method for get Students By FirstChar2");

        List<String> stringList = new ArrayList<>(studentRepository.findAll().stream()
                .parallel()
                .filter(e->e.getName().charAt(0) == firstChar)
                .map(student -> {return student.getName().toUpperCase();})
                .collect(Collectors.toList()));
        return stringList;
    }

    public Double getAverageAgeOfStream() {
        logger.info("Was invoked method for get Average Age Of Stream");
        List<Student> students = new ArrayList<>(studentRepository.findAll());
        return students.stream()
                .parallel()
                .mapToDouble(e -> e.getAge())
                .average()
                .getAsDouble();
    }
}
