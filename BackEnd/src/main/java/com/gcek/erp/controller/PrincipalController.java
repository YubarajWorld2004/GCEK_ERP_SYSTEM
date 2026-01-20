package com.gcek.erp.controller;

import com.gcek.erp.service.PrincipalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/principal")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PrincipalController {

    private final PrincipalService principalService;

    @GetMapping("/dashboard")
    public ResponseEntity<?> getDashboard() {
        try {
            return ResponseEntity.ok(principalService.getDashboardData());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
