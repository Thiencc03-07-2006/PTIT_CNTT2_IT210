package com.example.session04.model;

import java.time.LocalDate;

public class Project {
    int projectId;
    String projectName;
    String description;
    String projectManagerName;
    LocalDate startDate;
    LocalDate endDate;
    int totalNumberOfEmployees;

    public Project() {
    }

    public Project(int projectId, String projectName, String description, String projectManagerName, LocalDate startDate, LocalDate endDate, int totalNumberOfEmployees) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.description = description;
        this.projectManagerName = projectManagerName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalNumberOfEmployees = totalNumberOfEmployees;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectManagerName() {
        return projectManagerName;
    }

    public void setProjectManagerName(String projectManagerName) {
        this.projectManagerName = projectManagerName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getTotalNumberOfEmployees() {
        return totalNumberOfEmployees;
    }

    public void setTotalNumberOfEmployees(int totalNumberOfEmployees) {
        this.totalNumberOfEmployees = totalNumberOfEmployees;
    }
}
