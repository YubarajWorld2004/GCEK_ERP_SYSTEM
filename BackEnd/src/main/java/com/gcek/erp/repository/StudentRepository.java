package com.gcek.erp.repository;

import com.gcek.erp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByRegistrationNumber(String registrationNumber);
    Optional<Student> findByRollNumber(String rollNumber);
    List<Student> findByDepartment(String department);
    List<Student> findBySemester(String semester);
    List<Student> findByAcademicYear(String academicYear);
}