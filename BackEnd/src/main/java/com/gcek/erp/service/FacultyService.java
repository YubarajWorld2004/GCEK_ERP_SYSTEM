package com.gcek.erp.service;

import com.gcek.erp.entity.*;
import com.gcek.erp.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class FacultyService {

    private final FacultyRepository facultyRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final AttendanceRepository attendanceRepository;
    private final MarksRepository marksRepository;

    public Map<String, Object> getDashboardData(Long facultyId) {
        Map<String, Object> dashboard = new HashMap<>();
        dashboard.put("coursesAssigned", 4);
        dashboard.put("totalStudents", 120);
        dashboard.put("newNotices", 2);

        List<Map<String, Object>> activities = new ArrayList<>();
        activities.add(Map.of(
                "icon", "fa-check-circle",
                "type", "success",
                "description", "Attendance marked for Data Structures",
                "time", "Today, 10:30 AM"
        ));

        dashboard.put("recentActivities", activities);
        return dashboard;
    }

    public List<Student> getStudentsByCourse(String semester, String courseCode) {
        return studentRepository.findBySemester(semester);
    }

    public Attendance markAttendance(Attendance attendance) {
        attendance.setDate(LocalDate.now());
        return attendanceRepository.save(attendance);
    }

    public Marks uploadMarks(Marks marks) {
        return marksRepository.save(marks);
    }
}
