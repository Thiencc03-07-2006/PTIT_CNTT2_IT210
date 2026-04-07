package org.example.btth_session03.repository;

import org.example.btth_session03.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private final List<Student> students;

    public StudentRepository() {
        students = new ArrayList<>();

        students.add(new Student(1,  "Trần Thị Thu Trang",    "SV2022001", "CNTT", 2022, 3.60, "Đang học"));
        students.add(new Student(2,  "Phạm Hương Quỳnh",    "SV2022002", "CNTT", 2022, 3.80, "Đang học"));
        students.add(new Student(3,  "Ngô Trung Chiến",     "SV2021003", "CNTT", 2021, 3.20, "Đang học"));
        students.add(new Student(4,  "Phạm Minh Tuấn",    "SV2021004", "KTPM", 2021, 2.90, "Bảo lưu"));
        students.add(new Student(5,  "Vũ Đức Huy Hoàng",     "SV2020005", "KTPM", 2020, 3.90, "Tốt nghiệp"));
        students.add(new Student(6,  "Cao Chí Thiện",   "SV2022006", "CNTT", 2022, 3.10, "Đang học"));
        students.add(new Student(7,  "Đỗ Đức Mạnh",   "SV2023007", "HTTT", 2023, 3.50, "Đang học"));
        students.add(new Student(8,  "Tô Anh Tuấn",       "SV2020008", "KTPM", 2020, 3.95, "Tốt nghiệp"));
        students.add(new Student(9,  "Đặng Thanh Bình",     "SV2023009", "CNTT", 2023, 2.75, "Đang học"));
    }

    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    public Student findById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }
}