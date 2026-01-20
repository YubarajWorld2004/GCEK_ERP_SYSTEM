package com.gcek.erp.service;

import com.gcek.erp.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PrincipalService {

    public Map<String, Object> getDashboardData() {
        Map<String, Object> dashboard = new HashMap<>();
        dashboard.put("totalStudents", "1,250");
        dashboard.put("facultyMembers", "85");
        dashboard.put("departments", "6");
        dashboard.put("collegeAttendance", "86%");

        List<Map<String, Object>> deptStats = new ArrayList<>();
        deptStats.add(Map.of("name", "Computer Science", "students", 240, "faculty", 18, "attendance", 85));
        deptStats.add(Map.of("name", "Electrical", "students", 220, "faculty", 16, "attendance", 84));

        dashboard.put("departmentStats", deptStats);

        List<Map<String, Object>> activities = new ArrayList<>();
        activities.add(Map.of(
                "icon", "fa-users-cog",
                "type", "primary",
                "description", "2 new faculty members added",
                "time", "Today"
        ));

        dashboard.put("recentActivities", activities);
        return dashboard;
    }
}
