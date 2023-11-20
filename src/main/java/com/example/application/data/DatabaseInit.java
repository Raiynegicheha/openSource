package com.example.application.data;

import com.example.application.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.application.project.Project;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DatabaseInit implements CommandLineRunner {
    private final ProjectRepository projectRepository;
    @Override
    public void run(String... args) throws Exception {

        //generate seed data for project

        if (projectRepository.count()>0) {
            return;
        }

        for (int i=0; i<100;i++){
            Project project = new Project();
            project.setProjectName("Minet");
            project.setProjectDescription("Minet is a mining company");
            project.setProjectManager("John Doe");
            project.setProjectStatus("Active");
            project.setDepartmentName("Mining");
            project.setProjectStartDate(LocalDate.now());
            project.setProjectEndDate(LocalDate.now().plusYears(2));

            projectRepository.save(project);

        }


    }
}
