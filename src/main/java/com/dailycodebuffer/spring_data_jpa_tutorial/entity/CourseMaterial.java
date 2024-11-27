package com.dailycodebuffer.spring_data_jpa_tutorial.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name ="course_material_sequence",
            sequenceName = "course_material_sequences",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY // with fetch lazy :when you fetch course material it will not require fetch course table too
    )
    @JoinColumn(
            name="course_id", //this will be an extra field for CourseMaterial table to map to Course table as one to one
            referencedColumnName = "courseId" //is from the original name from Course class
    )
    private Course course;

}
