package com.bugtracker.employeemodule.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.bugtracker.employeemodule.entity.Employee;
import com.bugtracker.employeemodule.exception.EmployeeNotFoundException;
import com.bugtracker.employeemodule.repository.EmployeeRepository;
import com.bugtracker.employeemodule.service.EmployeeService;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeTestCase5 {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeService employeeService;

	@Test
	public void testDeleteEmployeeById_ValidId() throws EmployeeNotFoundException {
		// Create a sample employee
		Employee employee = new Employee();
		employee.setEmpId(1L);

		// Mock the behavior of the employeeRepository.findById() method
		when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

		// Call the deleteEmployeeById method with a valid employee
		employeeService.deleteEmployeeById(employee);

		// Verify that the employeeRepository.findById() method was called with the
		// correct ID
		verify(employeeRepository).findById(1L);

		// Verify that the employeeRepository.delete() method was called with the
		// employee
		verify(employeeRepository).delete(employee);
	}

	@Test
	public void testDeleteEmployeeById_InvalidId() {
		// Create a sample employee
		Employee employee = new Employee();
		employee.setEmpId(2L);

		// Mock the behavior of the employeeRepository.findById() method with an empty
		// optional
		when(employeeRepository.findById(2L)).thenReturn(Optional.empty());

		// Call the deleteEmployeeById method with an employee with an invalid ID
		assertThrows(EmployeeNotFoundException.class, () -> {
			employeeService.deleteEmployeeById(employee);
		});

		// Verify that the employeeRepository.findById() method was called with the
		// correct ID
		verify(employeeRepository).findById(2L);

		// Verify that the employeeRepository.delete() method was not called
		verify(employeeRepository, never()).delete(employee);
	}
}
