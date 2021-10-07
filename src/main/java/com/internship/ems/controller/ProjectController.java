package com.internship.ems.controller;

import com.internship.ems.model.Project;
import com.internship.ems.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public List<Project> getAllProject() {
        return projectService.getAll();
    }

    @GetMapping("/projects/{id}")
    public Project getProjectById(@PathVariable int id) {
        return projectService.getById(id);
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> saveProject(@Valid @RequestBody Project project) {
        return new ResponseEntity<Project>(projectService.save(project), HttpStatus.CREATED);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable int id, @Valid @RequestBody Project projectInfo) {
        return new ResponseEntity<Project>(projectService.updateProject(id, projectInfo), HttpStatus.CREATED);
    }

    @DeleteMapping("/projects/{id}")
    public void removeProject(@PathVariable int id) {
        projectService.deleteProject(id);
    }
}
