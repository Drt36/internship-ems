package com.internship.ems.service;

import com.internship.ems.dao.ProjectRepository;
import com.internship.ems.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public Project getById(int id) {
        return projectRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Project updateProject(int id, Project newProject) {
        Project project = projectRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        project.setName(newProject.getName());
        project.setDescription(newProject.getDescription());
        projectRepository.save(project);
        return project;
    }

    public List<Project> getAll() {
        List<Project> result = new ArrayList<>();
        projectRepository.findAll().forEach(result::add);
        return result;
    }

    public void deleteProject(int id) {
        projectRepository.deleteById(id);
    }
}
