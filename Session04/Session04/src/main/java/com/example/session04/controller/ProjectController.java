package com.example.session04.controller;

import com.example.session04.service.ProjectServiece;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    ProjectServiece projectServiece = new ProjectServiece();

    @GetMapping
    public String listProject(Model model) {
        model.addAttribute("projects", projectServiece.findAll());
        return "projects-list";
    }

    @GetMapping("/{id}")
    public String projectDetail(@PathVariable("id") int id, Model model) {
        model.addAttribute("project", projectServiece.findById(id));
        return "project";
    }
}
