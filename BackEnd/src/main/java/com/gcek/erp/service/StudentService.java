package com.gcek.erp.service;

import com.gcek.erp.entity.*;
import com.gcek.erp.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final AttendanceRepository attendanceRepository;
    private final MarksRepository marksRepository;
    private final NoticeRepository noticeRepository;
    private final CourseRepository courseRepository;

    public Map<String, Object> getDashboardData(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Get all attendance
        List<Attendance> allAttendance = attendanceRepository.findByStudentId(studentId);
        long total = allAttendance.size();
        long present = allAttendance.stream()
                .filter(a -> "PRESENT".equals(a.getStatus()))
                .count();
        double attendancePercentage = total > 0 ? (double) present / total * 100 : 0;

        // Count courses
        int currentCourses = (int) courseRepository.findBySemester(student.getSemester())
                .stream()
                .filter(c -> c.getDepartment().equals(student.getDepartment()))
                .count();

        // Count new notices
        LocalDate weekAgo = LocalDate.now().minusDays(7);
        int newNotices = noticeRepository.findByPublishDateAfter(weekAgo).size();

        // Activities
        List<Map<String, Object>> activities = new ArrayList<>();
        activities.add(Map.of(
                "icon", "fa-check-circle",
                "type", "success",
                "description", "Logged into ERP System",
                "time", "Just now"
        ));

        Map<String, Object> dashboard = new HashMap<>();
        dashboard.put("attendancePercentage", Math.round(attendancePercentage));
        dashboard.put("currentCourses", currentCourses);
        dashboard.put("newNotices", newNotices);
        dashboard.put("recentActivities", activities);

        return dashboard;
    }

    public List<Map<String, Object>> getAttendanceRecords(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
                
        // First get all courses for the student's semester
        List<Course> courses = courseRepository.findBySemester(student.getSemester())
                .stream()
                .filter(c -> c.getDepartment().equals(student.getDepartment()))
                .toList();
        
        if (courses.isEmpty()) {
            return Collections.emptyList();
        }

        List<Map<String, Object>> records = new ArrayList<>();
        
        for (Course course : courses) {
            // Get all attendance records for this student
            List<Attendance> allAttendance = attendanceRepository.findByStudentId(studentId);
            
            // Filter attendance for this specific course
            List<Attendance> courseAttendance = allAttendance.stream()
                    .filter(a -> a.getCourseId() != null && a.getCourseId().equals(course.getId()))
                    .toList();
                    
            long totalClasses = courseAttendance.size();
            long present = courseAttendance.stream()
                    .filter(a -> a.getStatus() != null && a.getStatus().equalsIgnoreCase("PRESENT"))
                    .count();
            long absent = totalClasses - present;
            int percentage = totalClasses > 0 ? (int) ((present * 100) / totalClasses) : 0;
            
            records.add(Map.of(
                    "name", course.getName() != null ? course.getName() : "N/A",
                    "totalClasses", totalClasses,
                    "present", present,
                    "absent", absent,
                    "percentage", percentage
            ));
        }

        return records;
    }

    public List<Map<String, Object>> getResults(Long studentId) {
        // Verify student exists
        if (!studentRepository.existsById(studentId)) {
            throw new RuntimeException("Student not found with id: " + studentId);
        }
        
        List<Marks> studentMarks = marksRepository.findByStudentId(studentId);
        if (studentMarks == null || studentMarks.isEmpty()) {
            return Collections.emptyList();
        }
        
        List<Map<String, Object>> results = new ArrayList<>();
        
        for (Marks mark : studentMarks) {
            Course course = courseRepository.findById(mark.getCourseId())
                    .orElseThrow(() -> new RuntimeException("Course not found for marks entry: " + mark.getId()));
                    
            results.add(Map.of(
                    "name", course.getName(),
                    "internal1", mark.getInternal1() + "/" + mark.getInternal1Max(),
                    "internal2", mark.getInternal2() + "/" + mark.getInternal2Max(),
                    "assignment", mark.getAssignment() + "/" + mark.getAssignmentMax(),
                    "lab", mark.getLab() + "/" + mark.getLabMax(),
                    "finalGrade", calculateGrade(mark)
            ));
        }

        return results;
    }
    
    private String calculateGrade(Marks mark) {
        // Implement your grade calculation logic here
        double totalMarks = mark.getInternal1() + mark.getInternal2() + 
                           mark.getAssignment() + mark.getLab();
        double maxMarks = mark.getInternal1Max() + mark.getInternal2Max() + 
                         mark.getAssignmentMax() + mark.getLabMax();
        double percentage = (totalMarks / maxMarks) * 100;
        
        if (percentage >= 90) return "A+";
        if (percentage >= 80) return "A";
        if (percentage >= 70) return "B";
        if (percentage >= 60) return "C";
        if (percentage >= 50) return "D";
        return "F";
    }

    public List<Notice> getNoticesForStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
                
        // Get all active notices
        List<Notice> allNotices = noticeRepository.findByActiveTrue();
        
        // Filter notices based on department and program
        return allNotices.stream()
                .filter(notice -> {
                    boolean matchesDepartment = notice.getDepartment() == null || 
                                              notice.getDepartment().equals("ALL") || 
                                              notice.getDepartment().equals(student.getDepartment());
                    boolean matchesProgram = notice.getProgram() == null || 
                                           notice.getProgram().equals("ALL") || 
                                           notice.getProgram().equals(student.getProgram());
                    return matchesDepartment && matchesProgram;
                })
                .collect(Collectors.toList());
    }

    public Student getProfile(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
}