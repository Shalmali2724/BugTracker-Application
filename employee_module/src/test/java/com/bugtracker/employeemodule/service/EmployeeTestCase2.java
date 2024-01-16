package com.bugtracker.employeemodule.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.bugtracker.employeemodule.entity.Employee;
import com.bugtracker.employeemodule.repository.EmployeeRepository;
import com.bugtracker.employeemodule.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeTestCase2 {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void testGetAllEmployees() {
        // Create a sample list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee());
        employees.add(new Employee());

        // Mock the behavior of the employeeRepository.findAll() method
        when(employeeRepository.findAll()).thenReturn(employees);

        // Call the getAllEmployees method
        List<Employee> retrievedEmployees = employeeService.getAllEmployees();

        // Verify that the employeeRepository.findAll() method was called
        verify(employeeRepository).findAll();

        // Assert that the retrievedEmployees list is the same as the mocked employees list
        assertEquals(employees, retrievedEmployees);
    }
}

