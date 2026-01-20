package com.gcek.erp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String registrationNumber;

    @Column(unique = true, nullable = false)
    private String rollNumber;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String academicYear;

    @Column(nullable = false)
    private String semester;

    private String program;
    private String email;
    private String phone;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}