package org.example.btth_session03.controller;

import org.example.btth_session03.model.Student;
import org.example.btth_session03.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping({"/students", "/studenthub/students"})
    public String listStudents(
            @RequestParam(name = "sortBy", required = false) String sortBy,
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "faculty", required = false) String faculty,
            Model model) {

        boolean isFiltering = (search != null && !search.isBlank())
                || (faculty != null && !faculty.isBlank());

        List<Student> students;
        if (isFiltering) {
            students = service.search(search, faculty);
            model.addAttribute("isFiltering", true);
            model.addAttribute("resultCount", students.size());
            model.addAttribute("searchKeyword", search  != null ? search  : "");
            model.addAttribute("facultyKeyword", faculty != null ? faculty : "");
        } else {
            students = service.getStudents(sortBy);
            model.addAttribute("isFiltering", false);
            model.addAttribute("sortBy", sortBy);
        }

        model.addAttribute("students", students);
        return "students/list";
    }

    @GetMapping({"/students/detail", "/studenthub/students/detail"})
    public String studentDetail(@RequestParam(name = "id") int id, Model model) {
        Student student = service.getById(id);
        if (student == null) return "redirect:/students";
        model.addAttribute("student", student);
        return "students/detail";
    }

    @GetMapping({"", "/", "/dashboard", "/studenthub", "/studenthub/", "/studenthub/dashboard"})
    public String dashboard(Model model) {
        Map<String, Object> stats = service.getDashboardStats();
        model.addAllAttributes(stats);
        return "dashboard";
    }
}