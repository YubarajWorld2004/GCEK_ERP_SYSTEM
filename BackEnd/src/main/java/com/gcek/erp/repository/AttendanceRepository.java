package com.gcek.erp.repository;

import com.gcek.erp.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByStudentId(Long studentId);
    List<Attendance> findByCourseId(Long courseId);
    List<Attendance> findByDate(LocalDate date);
    List<Attendance> findByStudentIdAndCourseId(Long studentId, Long courseId);
}
