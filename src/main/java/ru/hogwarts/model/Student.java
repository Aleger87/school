package ru.hogwarts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;


@Entity
public class Student {
    @Id
    @GeneratedValue
    private long idStudent;

    private String name;
    private int age;

    public Student() {

    }


    public Student(long idStudent, String name, int age) {
        this.idStudent = idStudent;
        this.name = name;
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(idStudent, student.idStudent) && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent, name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + idStudent +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
