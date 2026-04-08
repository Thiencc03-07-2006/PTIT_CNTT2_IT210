package com.example.session04.repository;

import com.example.session04.model.Project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {
    private static List<Project> projects = new ArrayList<>();

    static {
        projects.add(new Project(1, "Website bán hàng", "Xây dựng web e-commerce",
                "Nguyễn Văn A", LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 6, 1), 10));

        projects.add(new Project(2, "App mobile", "Ứng dụng đặt đồ ăn",
                "Trần Văn B", LocalDate.of(2024, 2, 1),
                LocalDate.of(2024, 7, 1), 8));
    }

    public List<Project> findAll() {
        return projects;
    }

    public Project findById(int id) {
        return projects.stream()
                .filter(c -> c.getProjectId() == (id))
                .findFirst()
                .orElse(null);
    }
}
