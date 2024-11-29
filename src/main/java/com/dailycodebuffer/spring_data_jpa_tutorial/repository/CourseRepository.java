package com.dailycodebuffer.spring_data_jpa_tutorial.repository;

import com.dailycodebuffer.spring_data_jpa_tutorial.entity.Course;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findByTitleContaining(
            String title,
            Pageable pageable);
}
