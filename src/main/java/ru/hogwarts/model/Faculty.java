package ru.hogwarts.model;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="faculty")
public class Faculty {
    @Id
    @GeneratedValue
    private long idFaculty;
    private String name;
    private String color;


    @OneToMany(cascade=ALL, mappedBy="faculty")
    private Collection<Student> students;

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    public Faculty() {

    }

    public Faculty(long idFaculty, String name, String color) {
        this.idFaculty = idFaculty;
        this.name = name;
        this.color = color;
    }


    public Long getIdFaculty() {
        return idFaculty;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setIdFaculty(Long idFaculty) {
        this.idFaculty = idFaculty;
    }

    public void setIdFaculty(long idFaculty) {
        this.idFaculty = idFaculty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return idFaculty == faculty.idFaculty && Objects.equals(name, faculty.name) && Objects.equals(color, faculty.color);// && Objects.equals(students, faculty.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFaculty, name, color); //,students);
    }

    @Override
    public String toString() {
        return "\nFaculty{" +
                "idFaculty=" + idFaculty +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", students=" + students +
                '}';
    }
}
