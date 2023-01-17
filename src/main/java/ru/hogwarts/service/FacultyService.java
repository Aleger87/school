package ru.hogwarts.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.model.Faculty;

import java.util.*;

@Service
public class FacultyService {
    private Map<Long, Faculty> facultyMap = new HashMap<>();
    private long counter = 0;

    public Faculty postFaculty(Faculty faculty) {
        faculty.setId(++counter);
        facultyMap.put(counter, faculty);
        return faculty;
    }

    public Faculty deleteFaculty(long id) {
        if (facultyMap.containsKey(id)) {
            return facultyMap.remove(id);
        }
        return null;
    }

    public Faculty putFaculty(Faculty faculty) {
        return facultyMap.put(faculty.getId(), faculty);
    }

    public Faculty getFaculty(long id) {
        if (facultyMap.containsKey(id)) {
            return facultyMap.get(id);
        }
        return null;
    }

    public Collection<Faculty> getFilterByColor(String color) {
        List<Faculty> list = new ArrayList<>();
        for (Faculty f: facultyMap.values()) {
            if (f.getColor().equals(color)) {
                list.add(f);
            }
        }
        return list;
    }

    public Collection<Faculty> getAllStudent() {
        List<Faculty> listFaculty =new ArrayList<>(facultyMap.values());
        return listFaculty;
    }
}
