package com.dailycodebuffer.spring_data_jpa_tutorial.repository;


import com.dailycodebuffer.spring_data_jpa_tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}
