package com.example.ppmtool.service;

import com.example.ppmtool.domain.Project;

import java.util.List;

public interface ProjectService {
    Project saveOrUpdate(Project project);

    Project findProjectByIdentifier(String projectId);

    List<Project> findAllProjects();
}
