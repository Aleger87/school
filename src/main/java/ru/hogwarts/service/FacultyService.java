package ru.hogwarts.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.model.Faculty;
import ru.hogwarts.model.Student;
import ru.hogwarts.repository.FacultyRepository;
import ru.hogwarts.repository.StudentRepository;

import java.util.*;


@Service
public class FacultyService {
    Logger logger = LoggerFactory.getLogger(FacultyService.class);

    private final FacultyRepository facultyRepository;
    private final StudentRepository studentRepository;

    public FacultyService(FacultyRepository facultyRepository,
                          StudentRepository studentRepository) {
        this.facultyRepository = facultyRepository;
        this.studentRepository = studentRepository;
    }


    public Faculty postFaculty(Faculty faculty) {
        logger.info("Was invoked method for post faculty");
       return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        logger.info("Was invoked method for delete faculty by id {}", id);
        facultyRepository.deleteById(id);
    }

    public Faculty putFaculty(Faculty faculty) {
        logger.info("Was invoked method for put faculty");
        return facultyRepository.save(faculty);
    }

    public Faculty getFaculty(long id) {
        logger.info("Was invoked method for get faculty by id");
       return facultyRepository.findById(id).get();
    }
    
    public Collection<Faculty> getFilterFacultyByColor(String color) {
        logger.info("Was invoked method for get filter faculty by color");
        return facultyRepository.findByColorContainsIgnoreCase(color);
    }

    public Collection<Faculty> getAllFaculty() {
        logger.info("Was invoked method for get all faculty");
        return facultyRepository.findAll();
    }

    public Collection<Student> getFacultyStudents(long id) {
        logger.info("Was invoked method for faculty students");
        return studentRepository.findStudentByFacultyId(id);
    }
}
