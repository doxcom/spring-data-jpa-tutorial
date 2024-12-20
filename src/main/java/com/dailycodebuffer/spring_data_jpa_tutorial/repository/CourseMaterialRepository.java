package com.dailycodebuffer.spring_data_jpa_tutorial.repository;

import com.dailycodebuffer.spring_data_jpa_tutorial.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
