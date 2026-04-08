package com.example.session04.service;

import com.example.session04.model.Project;

import java.util.List;

public class ProjectServiece {
    ProjectServiece projectServiece = new ProjectServiece();

    public List<Project> findAll() {
        return projectServiece.findAll();
    }

    public Project findById(int id) {
        return projectServiece.findById(id);
    }
}
