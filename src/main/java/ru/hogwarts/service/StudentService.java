package ru.hogwarts.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.model.Student;

import java.util.*;

@Service
public class StudentService {

    private Map<Long, Student> studentMap = new HashMap<>();
    private long counter = 0;

    public Student postStudent(Student student) {
        student.setId(++counter);
        studentMap.put(counter, student);
        return student;
    }

    public Student deleteStudent(long id) {
        if (studentMap.containsKey(id)) {
            return studentMap.remove(id);
        }
        return null;
    }

    public Student putStudent(Student student) {
        return studentMap.put(student.getId(), student);
    }

    public Student getStudent(long id) {
        if (studentMap.containsKey(id)) {
            return studentMap.get(id);
        }
        return null;
    }

    public Collection<Student> getStudentsFilterByAge(int age) {
        List<Student> list = new ArrayList<>();
        for (Student s : studentMap.values()) {
            if (s.getAge() == age) {
                list.add(s);
            }
        }
        return list;
    }

    public Collection<Student> getAllStudent() {
        List<Student> listStudents =new ArrayList<>(studentMap.values());
        return listStudents;
    }
}
