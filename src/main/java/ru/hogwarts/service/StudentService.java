package ru.hogwarts.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.model.Faculty;
import ru.hogwarts.model.Student;
import ru.hogwarts.repository.StudentRepository;

import java.util.*;

@Service
public class StudentService {

   private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student postStudent(Student student) {
      return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Student putStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudent(long id) {
        return studentRepository.findById(id).get();
    }

    public Collection<Student> getStudentsFilterByAge(int age) {
        return studentRepository.findByAge(age);
    }

    public Collection<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Collection<Student> getStudentsByAgeBetween(Integer min, Integer max) {
        return studentRepository.findByAgeBetween(min, max);
    }

    public Faculty getFacultyByStudent(long id) {
        //return studentRepository.findByIdStudent(id).getFaculty();
        return studentRepository.findFacultyByStudentId(id);
    }
}
