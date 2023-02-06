package ru.hogwarts.model;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class Student {
    @Id
    @GeneratedValue()
    private Long idStudent;

    private String name;
    private int age;

    @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public Student() {

    }

    public Student(long idStudent, String name, int age) {
        this.idStudent = idStudent;
        this.name = name;
        this.age = age;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public long getIdStudent() {
        return idStudent;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return idStudent == student.idStudent && age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent, name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", faculty=" + faculty +
                '}';
    }
}
