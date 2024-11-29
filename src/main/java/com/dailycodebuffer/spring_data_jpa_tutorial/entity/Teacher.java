package com.dailycodebuffer.spring_data_jpa_tutorial.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

  @Id
  @SequenceGenerator(
          name="teacher_sequence",
          sequenceName = "teacher_sequence",
          allocationSize=1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "teacher_sequence"
  )
  private Long teacherId;

  private String firstName;
  private String lastName;

/*
  @OneToMany(
          cascade = CascadeType.ALL
  )
  @JoinColumn( //unidirectional one to many teacher can have a list of courses
          name="teacher_id",
          referencedColumnName = "teacherId" //an existing column on Teacher table
  )
  private List<Course> courses; */
}
