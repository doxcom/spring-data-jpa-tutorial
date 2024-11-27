package com.dailycodebuffer.spring_data_jpa_tutorial.repository;


import com.dailycodebuffer.spring_data_jpa_tutorial.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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


    //native query
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )

    Student getStudentByEmailAddressNative(String emailId);

   //native named param
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )

    Student getStudentByEmailAddressNativeNamedParam(

      @Param("emailId") String emailId
    );

  //update the records based on email id
    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firsName, String emailId);






}
