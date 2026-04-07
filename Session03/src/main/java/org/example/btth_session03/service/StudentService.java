package org.example.btth_session03.service;

import org.example.btth_session03.model.Student;
import org.example.btth_session03.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> getStudents(String sortBy) {
        List<Student> list = repository.findAll();
        if ("name".equalsIgnoreCase(sortBy)) {
            list.sort(Comparator.comparing(Student::getFullName));
        } else if ("gpa".equalsIgnoreCase(sortBy)) {
            list.sort(Comparator.comparingDouble(Student::getGpa).reversed());
        }
        return list;
    }

    public Student getById(int id) {
        return repository.findById(id);
    }

    public List<Student> search(String keyword, String faculty) {
        List<Student> list = repository.findAll();
        if (keyword != null && !keyword.isBlank()) {
            String kw = keyword.trim().toLowerCase();
            list = list.stream()
                    .filter(s -> s.getFullName().toLowerCase().contains(kw)
                            || s.getStudentCode().toLowerCase().contains(kw))
                    .collect(Collectors.toList());
        }
        if (faculty != null && !faculty.isBlank()) {
            String fc = faculty.trim().toLowerCase();
            list = list.stream()
                    .filter(s -> s.getFaculty().toLowerCase().contains(fc))
                    .collect(Collectors.toList());
        }
        return list;
    }

    public Map<String, Object> getDashboardStats() {
        List<Student> all = repository.findAll();
        Map<String, Object> stats = new LinkedHashMap<>();

        stats.put("total", all.size());

        double avgGpa = all.stream().mapToDouble(Student::getGpa).average().orElse(0.0);
        stats.put("avgGpa", String.format("%.2f", avgGpa));

        Student topStudent = all.stream()
                .max(Comparator.comparingDouble(Student::getGpa))
                .orElse(null);
        stats.put("topStudent", topStudent);

        Map<String, Long> statusCount = new LinkedHashMap<>();
        statusCount.put("Đang học",   all.stream().filter(s -> "Đang học".equals(s.getStatus())).count());
        statusCount.put("Bảo lưu",    all.stream().filter(s -> "Bảo lưu".equals(s.getStatus())).count());
        statusCount.put("Tốt nghiệp", all.stream().filter(s -> "Tốt nghiệp".equals(s.getStatus())).count());
        stats.put("statusCount", statusCount);

        Map<String, String> statusPercent = new LinkedHashMap<>();
        statusCount.forEach((status, count) ->
                statusPercent.put(status,
                        all.isEmpty() ? "0%" : String.format("%.1f%%", count * 100.0 / all.size())));
        stats.put("statusPercent", statusPercent);

        return stats;
    }
}