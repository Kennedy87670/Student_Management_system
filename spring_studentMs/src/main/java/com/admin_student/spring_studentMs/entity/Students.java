package com.admin_student.spring_studentMs.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String userName;

    private String email;

    private String Grade;

//    // Relationship to parents
//    @ManyToOne
//    @JoinColumn(name = "parent_id")
//    private Parents parents;
//
//    @ManyToMany
//    @JoinTable(
//            name = "student_grades",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name = "grade_id"))
//    private Set<Grades> grades = new HashSet<>();
//
//    @OneToMany(mappedBy = "students")
//    private List<Complaint> complaints = new ArrayList<>();



}