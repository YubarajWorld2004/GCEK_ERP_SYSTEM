package com.gcek.erp.service;

import com.gcek.erp.entity.*;
import com.gcek.erp.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class HODService {

    private final DepartmentRepository departmentRepository;
    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;
    private final CourseRepository courseRepository;

    public Map<String, Object> getDashboardData(String department) {
        List<Student> students = studentRepository.findByDepartment(department);
        List<Faculty> faculty = facultyRepository.findByDepartment(department);
        List<Course> courses = courseRepository.findByDepartment(department);

        Map<String, Object> dashboard = new HashMap<>();
        dashboard.put("totalStudents", students.size());
        dashboard.put("facultyMembers", faculty.size());
        dashboard.put("activeCourses", courses.size());
        dashboard.put("avgAttendance", "85%");

        Map<String, Integer> distribution = new HashMap<>();
        distribution.put("1st Year", 60);
        distribution.put("2nd Year", 58);
        distribution.put("3rd Year", 62);
        distribution.put("4th Year", 60);

        dashboard.put("yearDistribution", distribution);

        List<Map<String, Object>> activities = new ArrayList<>();
        activities.add(Map.of(
                "icon", "fa-user-plus",
                "type", "success",
                "description", "2 new students added",
                "time", "Today"
        ));

        dashboard.put("recentActivities", activities);
        return dashboard;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
}
