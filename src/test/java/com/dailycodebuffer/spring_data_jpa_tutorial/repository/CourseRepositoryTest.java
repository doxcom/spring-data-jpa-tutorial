package com.dailycodebuffer.spring_data_jpa_tutorial.repository;

import com.dailycodebuffer.spring_data_jpa_tutorial.entity.Course;
import com.dailycodebuffer.spring_data_jpa_tutorial.entity.Student;
import com.dailycodebuffer.spring_data_jpa_tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;


    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses: " + courses);
    }


    @Test
    public void saveCourseWithTeacher(){ //a new teacher will be created, new course
        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Singh")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1,2);

       List<Course> courses =
               courseRepository.findAll(firstPageWithThreeRecords).getContent();

       long totalElements = courseRepository.findAll(firstPageWithThreeRecords)
                       .getTotalElements();
       long totalPages = courseRepository.findAll(firstPageWithThreeRecords)
                       .getTotalPages();


        System.out.println("total pages  : " + totalPages);

        System.out.println("total elements : " + totalElements);

        System.out.println("courses: " + courses);

    }


    @Test
    public void findAllSorting(){
        Pageable sortByTitle =
                PageRequest.of(0,2,Sort.by("title"));

        Pageable sortByCreditDesc =
                        PageRequest.of(0,2,Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(0,2,Sort.by("title")
                        .descending()
                        .and(Sort.by("credit")));

          List<Course> courses
                  = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("All sorting courses: " + courses);
    }


    @Test
    public void printfindByTitleContaining(){
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);

           //     List<Course> courses =
             //           courseRepository.findByTitleContaining(
               //                 "D",
                 //               firstPageTenRecords);

        List<Course> courses =
                courseRepository.findByTitleContaining(
                        "D",firstPageTenRecords).getContent();
        System.out.println("courses: " + courses);

    }


    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                        .firstName("Rafael")
                        .lastName("Rivera")
                        .build();

        Student student = Student.builder()
                .firstName("Aldo")
                .lastName("Perez")
                .emailId("aldo13@gmail.com")
                .build();

        Course course = Course
                .builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudent(student);

        courseRepository.save(course);
    }


}