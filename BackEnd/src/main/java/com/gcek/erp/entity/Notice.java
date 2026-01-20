package com.gcek.erp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "notices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private String category; // INSTITUTIONAL, DEPARTMENTAL, STUDENT

    private String department; // ALL or specific department
    private String program; // ALL, UG, PG
    private String publisher;

    @Column(nullable = false)
    private LocalDate publishDate;

    @Column(columnDefinition = "boolean default true")
    private boolean active = true;
}