package com.dailycodebuffer.spring_data_jpa_tutorial.repository;

import com.dailycodebuffer.spring_data_jpa_tutorial.entity.Course;
import com.dailycodebuffer.spring_data_jpa_tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}