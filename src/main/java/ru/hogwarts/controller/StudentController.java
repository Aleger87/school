package ru.hogwarts.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.model.Faculty;
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
    public ResponseEntity<Student> postStudent(@RequestBody Student student) {
      return   ResponseEntity.ok(studentService.postStudent(student));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        Student student = studentService.getStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        studentService.deleteStudent(id);
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
    public ResponseEntity<Student> putStudent(@RequestBody Student student) {
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

    @GetMapping("/age/between")
    public ResponseEntity<Collection<Student>> getStudentByAgeBetween(@RequestParam(required = false) Integer min,
                                                          @RequestParam(required = false) Integer max) {
        return ResponseEntity.ok(studentService.getStudentsByAgeBetween(min, max));
    }

    @GetMapping("/student-faculty/{id}")
    public ResponseEntity<Faculty> getFacultyByStudent (@PathVariable Long id){
        return ResponseEntity.ok(studentService.getFacultyByStudent(id));
    }

}
