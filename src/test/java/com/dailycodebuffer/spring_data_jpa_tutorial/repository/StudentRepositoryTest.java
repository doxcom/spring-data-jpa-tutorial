package com.dailycodebuffer.spring_data_jpa_tutorial.repository;

import com.dailycodebuffer.spring_data_jpa_tutorial.entity.Guardian;
import com.dailycodebuffer.spring_data_jpa_tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
               // .guardianName("Nikkhil")
               // .guardianEmail("nikk13@gmail.com")
               // .guardianMobile("390284938943289")
                .build();

        studentRepository.save(student);

    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("nikkumar@gmail.com")
                .name("nikhil")
                .mobile("493787498748")
                .build();
        Student student = Student.builder()
                .firstName("shiva")
                .emailId("shiva23@gmail.com")
                .lastName("kumhar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }


    @Test
    public void printAllStudent(){
        List<Student> studentsList = studentRepository.findAll();

        System.out.println("student list :  " + studentsList);
    }



    @Test
    public void printStudentByFirstName() {

        List<Student> students = studentRepository.findByFirstName("aldo");

        System.out.println("student by first Name :  " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {

        List<Student> students = studentRepository.findByFirstNameContaining("sh");

        System.out.println("student by containing characters:  " + students);
    }


    @Test
    public void printStudentBasedOnGuardianName(){

        List<Student> students =
                studentRepository.findByGuardianName("Nikhil");
        System.out.println("students = " + students);
    }


    @Test
    public void printgetStudentByEmailAddress(){
        Student student =
                studentRepository.getStudentByEmailAddress(
                        "aldoperez@gmail.com"
                );
        System.out.println("student by email address :  " + student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress(){
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress("shiva23@gmail.com");
        System.out.println("firstName = " + firstName);
    }
}