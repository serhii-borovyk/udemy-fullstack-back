package com.example.ppmtool.controller;

import com.example.ppmtool.domain.Project;
import com.example.ppmtool.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project) {
        Project savedProject = projectService.saveOrUpdate(project);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId) {
        Project project = projectService.findProjectByIdentifier(projectId);
        return ResponseEntity.ok(project);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProjects() {
        List<Project> allProjects = projectService.findAllProjects();
        return ResponseEntity.ok(allProjects);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProjectById(@PathVariable String projectId) {
        projectService.deleteProjectByIdentifier(projectId);
        return ResponseEntity.ok("Project with ID: '" + projectId + "' was deleted");
    }
}
