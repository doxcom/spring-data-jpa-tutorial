package com.dailycodebuffer.spring_data_jpa_tutorial.repository;

import com.dailycodebuffer.spring_data_jpa_tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentRepositoryTest {


    //object for student reporitory
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("aldoperez@gmail.com")
                .firstName("aldo")
                .lastName("perez")
                .guardianName("Nikkhil")
                .guardianEmail("nikk13@gmail.com")
                .guardianMobile("390284938943289")
                .build();

        studentRepository.save(student);

    }
}