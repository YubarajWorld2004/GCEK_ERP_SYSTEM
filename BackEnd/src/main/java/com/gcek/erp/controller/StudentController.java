package com.gcek.erp.controller;

import com.gcek.erp.entity.Student;
import com.gcek.erp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/dashboard/{id}")
    public ResponseEntity<?> getDashboard(@PathVariable Long id) {
        try {
            Map<String, Object> dashboard = studentService.getDashboardData(id);
            return ResponseEntity.ok(dashboard);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/attendance/{id}")
    public ResponseEntity<?> getAttendance(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(studentService.getAttendanceRecords(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/results/{id}")
    public ResponseEntity<?> getResults(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(studentService.getResults(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/notices/{id}")
    public ResponseEntity<?> getNotices(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(studentService.getNoticesForStudent(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<?> getProfile(@PathVariable Long id) {
        try {
            Student student = studentService.getProfile(id);
            return ResponseEntity.ok(student);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
