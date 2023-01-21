package ru.hogwarts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.model.Faculty;
import ru.hogwarts.service.FacultyService;

import java.util.Collection;

@RequestMapping("faculty")
@RestController

public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty postFaculty(@RequestBody Faculty faculty) {
        return facultyService.postFaculty(faculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteFaculty(@PathVariable Long id) {
        Faculty deleteFaculty = facultyService.getFaculty(id);
        if (deleteFaculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }


    @GetMapping("{id}")
    public ResponseEntity<Faculty>  getFaculty(@PathVariable Long id) {
        Faculty getFaculty = facultyService.getFaculty(id);
        if (getFaculty==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyService.getFaculty(id));
    }


    @PutMapping
    public ResponseEntity putFaculty(@RequestBody Faculty faculty) {
        return ResponseEntity.ok(facultyService.putFaculty(faculty));
    }

    @GetMapping("color/{color}")
    public ResponseEntity<Collection<Faculty>> filterByColor(@PathVariable String color) {
        return ResponseEntity.ok(facultyService.getFilterFacultyByColor(color));
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> getAllFaculty () {
        return ResponseEntity.ok(facultyService.getAllFaculty());
    }


}
