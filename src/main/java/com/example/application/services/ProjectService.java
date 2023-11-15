package com.example.application.services;

import com.example.application.project.ProjectRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.BrowserCallable;
import dev.hilla.crud.ListRepositoryService;
import org.springframework.stereotype.Service;
import com.example.application.project.Project;

@Service
@BrowserCallable
@AnonymousAllowed
public class ProjectService extends ListRepositoryService<Project,Long, ProjectRepository>{
}
