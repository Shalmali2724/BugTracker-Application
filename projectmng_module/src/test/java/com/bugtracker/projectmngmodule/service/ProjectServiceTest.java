package com.bugtracker.projectmngmodule.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.bugtracker.projectmngmodule.entity.Employee;
import com.bugtracker.projectmngmodule.entity.Project;
import com.bugtracker.projectmngmodule.exception.ProjectNotFoundException;
import com.bugtracker.projectmngmodule.repository.AdminRepository;
import com.bugtracker.projectmngmodule.repository.ProjectRepository;

@SpringBootTest
public class ProjectServiceTest {
	
	
	@InjectMocks
	private ProjectServiceImpl ProjectService;
	
	@Mock
	private ProjectRepository projectRepository;
	
	@InjectMocks
	private AdminServiceImpl adminService = new AdminServiceImpl();

	@Mock
	private AdminRepository adminRepository;
	


	
	@Test
	public void testProjectNotFoundException() {
		when(projectRepository.findById(1L)).thenThrow(ProjectNotFoundException.class);
		assertThrows(ProjectNotFoundException.class, () -> ProjectService.getProjectById(1L));
		// Verify that the findById() method is called with the expected argument
	    verify(projectRepository).findById(1L);

	}
	@Test
    public void testGetAllProject() {
        // Create a list of projects for the mock repository to return
List<Project> expectedProjects = new ArrayList<>();
        
        Project project1 = new Project();
        project1.setProjId(1L);
        project1.setProjName("Project 1");
        expectedProjects.add(project1);
        
        Project project2 = new Project();
        project2.setProjId(2L);
        project2.setProjName("Project 2");
        expectedProjects.add(project2);

        // Mock the repository's findAll method to return the list of projects
        when(projectRepository.findAll()).thenReturn(expectedProjects);
        
     // Call the method under test
        List<Project> actualProjects = ProjectService.getAllProject();

        // Assert that the returned list of projects matches the expected list
        assertEquals(expectedProjects, actualProjects);


	}
	
	
	

}
