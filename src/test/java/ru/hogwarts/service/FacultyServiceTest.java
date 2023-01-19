package ru.hogwarts.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.hogwarts.model.Faculty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FacultyServiceTest {

    private final FacultyService facultyService = new FacultyService();

    private Faculty faculty = new Faculty(0, "test", "test");
    private List<Faculty> actualList = new ArrayList<>();

    @BeforeEach
    void setUp (){
        facultyService.postFaculty(faculty);
        actualList.add(faculty);
    }

    @Test
    void postFaculty() {
        Assertions.assertEquals(facultyService.getAllFaculty(), actualList);
    }

    @Test
    void deleteFaculty() {
        Assertions.assertEquals(facultyService.deleteFaculty(1), faculty);
    }

    @Test
    void putFaculty() {
        Faculty newFaculty = new Faculty(1, "test1", "test1");
        facultyService.putFaculty(newFaculty);
        Assertions.assertEquals(facultyService.getFaculty(1), newFaculty);
    }

    @Test
    void getFaculty() {
        Assertions.assertEquals(facultyService.getFaculty(1), faculty);
    }

    @Test
    void getFilterByColor() {
        Assertions.assertEquals(facultyService.getFilterFacultyByColor("test"), actualList.stream().filter(e->e.getColor().equals("test")).toList());
    }

    @Test
    void getAllStudent() {
        Assertions.assertEquals(facultyService.getAllFaculty(), actualList);
    }
}