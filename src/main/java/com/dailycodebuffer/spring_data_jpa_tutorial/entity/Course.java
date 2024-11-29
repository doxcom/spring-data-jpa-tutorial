package com.dailycodebuffer.spring_data_jpa_tutorial.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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


}
