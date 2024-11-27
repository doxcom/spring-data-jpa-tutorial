package com.dailycodebuffer.spring_data_jpa_tutorial.repository;


import com.dailycodebuffer.spring_data_jpa_tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

     List<Student> findByFirstName(String firstName); //only put definition, not how to implemented

    List<Student> findByFirstNameContaining(String name);


    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);


    Student findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1") //query should be implemented based on classes not tables names
    Student getStudentByEmailAddress(String emailId);


    //JPQL
    @Query("select s.firstName from Student s where s.emailId = ?1") //query should be implemented based on classes not tables names
    String getStudentFirstNameByEmailAddress(String emailId);


}
