package ru.hogwarts.service;

import net.minidev.json.JSONObject;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.hogwarts.controller.StudentController;
import ru.hogwarts.model.Student;
import ru.hogwarts.repository.AvatarRepository;
import ru.hogwarts.repository.FacultyRepository;
import ru.hogwarts.repository.StudentRepository;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
@AutoConfigureMockMvc
public class StudentTests {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentRepository studentRepository;

    @MockBean
    private AvatarRepository avatarRepository;

    @MockBean
    private FacultyRepository facultyRepository;

    @SpyBean
    private StudentService studentService;

    @SpyBean
    private AvatarService avatarService;

   @SpyBean
   private FacultyService facultyService;

    @InjectMocks
    private StudentController studentController;

    final String name = "Test";
    final int age = 21;
    final Long id = 1L;

    @Test
    public void testStudents() throws Exception {

        Student student = new Student(id, name, age);


        JSONObject studentObject = new JSONObject();
        studentObject.put("idStudent", id);
        studentObject.put("name", name);
        studentObject.put("age", age);

        when(studentRepository.save(any(Student.class))).thenReturn(student);
        when(studentRepository.findByAge(eq(age))).thenReturn(Collections.singleton(student));
        when(studentRepository.findByIdStudent(eq(id))).thenReturn(Optional.of(student).orElse(new Student(id, name, age)));


        mockMvc.perform(MockMvcRequestBuilders
                        .post("/student")
                        .content(studentObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idStudent").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.age").value(age));

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/student")
                        .content(studentObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idStudent").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.age").value(age));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/{id}", id)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idStudent").value(id))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.age").value(age));

           /* mockMvc.perform(MockMvcRequestBuilders
                            .get("/student/age/{age}", age)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].idStudent").value(id))
                    .andExpect(jsonPath("$[0].name").value(name))
                    .andExpect(jsonPath("$[0].age").value(age));

            mockMvc.perform(MockMvcRequestBuilders
                            .delete("/student/{id}" + id)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());*/
    }

}

