package com.gcek.erp.controller;

import com.gcek.erp.entity.Faculty;
import com.gcek.erp.entity.Student;
import com.gcek.erp.service.HODService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/hod")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class HODController {

    private final HODService hodService;

    @GetMapping("/dashboard/{department}")
    public ResponseEntity<?> getDashboard(@PathVariable String department) {
        try {
            return ResponseEntity.ok(hodService.getDashboardData(department));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/students")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        try {
            return ResponseEntity.ok(hodService.addStudent(student));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/faculty")
    public ResponseEntity<?> addFaculty(@RequestBody Faculty faculty) {
        try {
            return ResponseEntity.ok(hodService.addFaculty(faculty));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
