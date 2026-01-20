package com.gcek.erp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "faculty")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String employeeId;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String department;

    private String designation;
    private String qualification;
    private String email;
    private String phone;

    @Column(columnDefinition = "int default 0")
    private int coursesAssigned;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}