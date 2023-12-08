package com.admin_student.spring_studentMs.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "parents")
public class Parents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String userName;


//    //     Relationship to students
//    @OneToMany(mappedBy = "parents")
//    private List<Students> students = new ArrayList<>() ;

}
