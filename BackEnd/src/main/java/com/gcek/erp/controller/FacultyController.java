package com.gcek.erp.controller;

import com.gcek.erp.entity.Attendance;
import com.gcek.erp.entity.Marks;
import com.gcek.erp.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/faculty")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService = null;

    @GetMapping("/dashboard/{id}")
    public ResponseEntity<?> getDashboard(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(facultyService.getDashboardData(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/attendance")
    public ResponseEntity<?> markAttendance(@RequestBody Attendance attendance) {
        try {
            return ResponseEntity.ok(facultyService.markAttendance(attendance));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/marks")
    public ResponseEntity<?> uploadMarks(@RequestBody Marks marks) {
        try {
            return ResponseEntity.ok(facultyService.uploadMarks(marks));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
