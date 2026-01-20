package com.gcek.erp.repository;

import com.gcek.erp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByDepartment(String department);
    List<Course> findBySemester(String semester);
    List<Course> findByFacultyInCharge(String facultyName);
    Optional<Course> findByCourseCode(String courseCode);
}
