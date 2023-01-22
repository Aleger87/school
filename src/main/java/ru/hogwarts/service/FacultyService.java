package ru.hogwarts.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.model.Faculty;
import ru.hogwarts.repository.FacultyRepository;

import java.util.*;


@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    public Faculty postFaculty(Faculty faculty) {
       return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public Faculty putFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty getFaculty(long id) {
       return facultyRepository.findById(id).get();
    }
    
    public Collection<Faculty> getFilterFacultyByColor(String color) {
        List<Faculty> getFilter =new ArrayList<>(facultyRepository.findAll());
        return getFilter.stream().filter(e->e.getColor().equals(color)).toList();
    }

    public Collection<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }
}
