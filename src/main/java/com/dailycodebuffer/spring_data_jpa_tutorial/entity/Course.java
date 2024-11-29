package com.dailycodebuffer.spring_data_jpa_tutorial.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder //for every course there will be a course material
public class Course {


    @Id
    @SequenceGenerator(
            name="course_sequence",
            sequenceName = "course_sequence",
            allocationSize=1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;


    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;


    @ManyToOne(
            cascade = CascadeType.ALL //when you try to save course or teacher all the
                                      // changes on these tables will be related
    )
    @JoinColumn(
            name ="teacher_id",
            referencedColumnName = "teacherId" //from class/table TEACHER
    )
    private Teacher teacher;


    //
    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "student_course_map", //name of table that will join course and student tables
            joinColumns = @JoinColumn(
                    name = "course_id", //column from course table
                    referencedColumnName = "courseId" //column on the Course Class with primary id
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            ) //table with the mapping keys between the course and student table (many to many mapping)
    )
    private List<Student> students;

    public void addStudent(Student student) {
        if(students == null) students = new ArrayList<>();
        students.add(student);
    }
}
