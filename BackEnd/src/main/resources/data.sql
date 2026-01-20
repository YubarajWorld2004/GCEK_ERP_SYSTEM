-- Insert Users
INSERT INTO users (id, username, password, role, email, full_name, department, phone, active)
VALUES
(1, '2201110014', 'password123', 'STUDENT', 'asha.kiran@gcek.ac.in', 'Asha Kiran Samantaray', 'Computer Science and Engineering', '9876543210', true),
(2, '2201110076', 'password123', 'STUDENT', 'yubaraj@gcek.ac.in', 'Yubaraj Mohanty', 'Computer Science and Engineering', '9876543211', true),
(3, 'faculty001', 'password123', 'FACULTY', 'faculty@gcek.ac.in', 'Dr. Faculty Member', 'Computer Science and Engineering', '9876543212', true),
(4, 'hod_cs', 'password123', 'HOD', 'hod.cs@gcek.ac.in', 'Dr. HOD CS', 'Computer Science and Engineering', '9876543213', true),
(5, 'principal', 'password123', 'PRINCIPAL', 'principal@gcek.ac.in', 'Dr. Principal', 'ALL', '9876543214', true);

-- Insert Students
INSERT INTO students (id, registration_number, roll_number, full_name, department, academic_year, semester, program, email, phone, user_id)
VALUES
(1, '2201110014', 'CS2022001', 'Asha Kiran Samantaray', 'Computer Science and Engineering', '2022-2026', '4', 'B.Tech', 'asha.kiran@gcek.ac.in', '9876543210', 1),
(2, '2201110076', 'CS2022002', 'Yubaraj Mohanty', 'Computer Science and Engineering', '2022-2026', '4', 'B.Tech', 'yubaraj@gcek.ac.in', '9876543211', 2);

-- Insert Faculty
INSERT INTO faculty (id, employee_id, full_name, department, designation, email, phone, courses_assigned, user_id)
VALUES
(1, 'FAC001', 'Dr. Faculty Member', 'Computer Science and Engineering', 'Professor', 'faculty@gcek.ac.in', '9876543212', 4, 3);

-- Insert Departments
INSERT INTO departments (id, code, name, hod, total_students, total_faculty, avg_attendance)
VALUES
(1, 'CSE', 'Computer Science and Engineering', 'Dr. HOD CS', 240, 18, 85),
(2, 'EE', 'Electrical Engineering', 'Dr. HOD EE', 220, 16, 84),
(3, 'ME', 'Mechanical Engineering', 'Dr. HOD ME', 210, 15, 86);

-- Insert Courses
INSERT INTO courses (id, course_code, course_name, department, semester, credits, faculty_in_charge, program)
VALUES
(1, 'CS401', 'Data Structures', 'Computer Science and Engineering', '4', 4, 'Dr. Faculty Member', 'UG'),
(2, 'CS402', 'Algorithms', 'Computer Science and Engineering', '4', 4, 'Dr. Faculty Member', 'UG');

-- Insert Notices
INSERT INTO notices (id, title, content, category, department, program, publisher, publish_date, active)
VALUES
(1, 'Mid-term Examination Schedule', 'The mid-term examinations for all UG programs will commence from next week.', 'ACADEMIC', 'ALL', 'UG', 'Examination Cell', '2024-01-10', true),
(2, 'College Foundation Day', 'College will remain closed for Foundation Day celebration.', 'GENERAL', 'ALL', 'ALL', 'Principal Office', '2024-01-05', true);