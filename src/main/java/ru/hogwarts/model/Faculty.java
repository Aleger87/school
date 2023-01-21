package ru.hogwarts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Faculty {
    @Id
    @GeneratedValue
    private long idFaculty;
    private String name;
    private String color;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(idFaculty, faculty.idFaculty) && Objects.equals(name, faculty.name) && Objects.equals(color, faculty.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFaculty, name, color);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + idFaculty +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
