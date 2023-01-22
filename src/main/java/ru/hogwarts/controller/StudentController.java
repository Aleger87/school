package ru.hogwarts.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.model.Student;
import ru.hogwarts.service.StudentService;

import java.util.Collection;

@RequestMapping("student")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student postStudent(@RequestBody Student student) {
        return studentService.postStudent(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        Student student = studentService.getStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.getStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }


    @PutMapping
    public ResponseEntity putStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.putStudent(student));
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<Collection<Student>> filterByAge(@PathVariable int age) {
        return ResponseEntity.ok(studentService.getStudentsFilterByAge(age));
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> getAllStudent () {
        return ResponseEntity.ok(studentService.getAllStudent());
    }





}
