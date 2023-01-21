//package ru.hogwarts.service;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import ru.hogwarts.model.Student;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class StudentServiceTest {
//    private final StudentService studentService=new StudentService();
//    private Student student = new Student(1, "test", 18);
//    private List<Student> studentList = new ArrayList<>();
//
//    @BeforeEach
//    void setUp(){
//        studentList.add(student);
//        studentService.postStudent(student);
//    }
//
//    @Test
//    void postStudent() {
//        Assertions.assertEquals(studentService.postStudent(student), student);
//    }
//
//    @Test
//    void deleteStudent() {
//        Assertions.assertEquals(studentService.deleteStudent(1), student);
//    }
//
//    @Test
//    void putStudent() {
//        Student newStudent = new Student(1, "test1", 19);
//        studentService.putStudent(newStudent);
//        Assertions.assertEquals(studentService.putStudent(newStudent), newStudent);
//    }
//
//    @Test
//    void getStudent() {
//        Assertions.assertEquals(studentService.getStudent(1), student);
//    }
//
//    @Test
//    void getStudentsFilterByAge() {
//        Assertions.assertEquals(studentService.getStudentsFilterByAge(18), studentList.stream().filter(e->e.getAge() == 18).toList());
//    }
//
//    @Test
//    void getAllStudent() {
//        Assertions.assertEquals(studentService.getAllStudent(), studentList);
//    }
//}