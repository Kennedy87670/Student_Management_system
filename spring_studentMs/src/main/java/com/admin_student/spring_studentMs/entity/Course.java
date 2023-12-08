package com.admin_student.spring_studentMs.entity;



import jakarta.persistence.*;
import lombok.*;



@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "course_id")
    private Long id;


    private String subject;


    private String code;


    private String description;

//    @JsonIgnore
//    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
//    private List<Grades> grades;


}
