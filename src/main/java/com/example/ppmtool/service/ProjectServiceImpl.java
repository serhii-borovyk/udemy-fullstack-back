package com.example.ppmtool.service;

import com.example.ppmtool.domain.Project;
import com.example.ppmtool.exceptions.ProjectIdException;
import com.example.ppmtool.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public Project saveOrUpdate(Project project) {
        Objects.requireNonNull(project);
        project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
        try {
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project ID '" + project.getProjectIdentifier() + "' is already exists");
        }
    }
}
