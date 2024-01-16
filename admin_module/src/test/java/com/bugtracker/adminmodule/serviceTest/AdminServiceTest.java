//package com.bugtracker.adminmodule.serviceTest;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//
//import com.bugtracker.adminmodule.dto.AdminDto;
//import com.bugtracker.adminmodule.dto.Employee;
//import com.bugtracker.adminmodule.entity.Admin;
//import com.bugtracker.adminmodule.entity.UserTable;
//import com.bugtracker.adminmodule.exception.AdminNotFoundException;
//import com.bugtracker.adminmodule.repository.AdminRepository;
//import com.bugtracker.adminmodule.repository.UserTableRepository;
//import com.bugtracker.adminmodule.service.AdminService;
//import com.bugtracker.adminmodule.service.AdminServiceImpl;
//
//
//
//public class AdminServiceTest {
//	
//	@InjectMocks
//	private AdminServiceImpl adminService = new AdminServiceImpl();
//
//	@Mock
//	private AdminRepository adminRepository;
//	
//	 @Mock
//	 private UserTableRepository userTableRepository;
//	 
////	 @Test
////	  public void testAddAdmin() {
////	        // Create a sample adminDto for testing
////	        AdminDto adminDto = new AdminDto();
////	        adminDto.setAdminName("John Doe");
////	        adminDto.setAdminEmail("john.doe@example.com");
////	        adminDto.setAdminContact("1234567890");
////	        adminDto.setAdminAddress("123 Street, City");
////	        adminDto.setRole("ADMIN");
////	        adminDto.setPassword("password");
////	        
////	        
////	 
////	        
////	     // Mock the behavior of the adminRepository.getByAdminEmail() method
////	        Optional<Admin> adminOptional = Optional.empty();
////	        Mockito.when(adminRepository.getByAdminEmail(adminDto.getAdminEmail())).thenReturn(adminOptional);
////	        
////	     // Mock the behavior of the adminRepository.save() method
////
////	        Mockito.when(adminRepository.save(Mockito.any(Admin.class))).thenAnswer(invocation -> invocation.getArgument(0));
////
////	        // Create a mock userTable object
////	        UserTable userTable = new UserTable();
////	        userTable.setUserId(1L);
////	        userTable.setUserName(adminDto.getAdminEmail());
////	        userTable.setPassword(adminDto.getPassword());
////	        userTable.setUserEmail(adminDto.getAdminEmail());
////	        userTable.setRole(adminDto.getRole());
////	        
////	        Mockito.when(userTableRepository.save(Mockito.any(UserTable.class))).thenReturn(userTable);
////
////	        
////	        AdminDto result = adminService.addAdmin(adminDto);
////	        
////	        Mockito.verify(adminRepository).getByAdminEmail(adminDto.getAdminEmail());
////	        Mockito.verify(adminRepository).save(Mockito.any(Admin.class));
////	        Mockito.verify(userTableRepository).save(Mockito.any(UserTable.class));
////	        
////	     // Assertions
////	        assertNotNull(result);
////
////	        assertEquals(adminDto.getAdminName(), result.getAdminName());
////	        assertEquals(adminDto.getAdminEmail(), result.getAdminEmail());
////	        assertEquals(adminDto.getAdminContact(), result.getAdminContact());
////	        assertEquals(adminDto.getAdminAddress(), result.getAdminAddress());
////	        assertEquals(adminDto.getRole(), result.getRole());
////
////	 
//	 
//	 
//	 
//	 
//
//	
////	@Mock
////    private EmployeeRepository employeeRepository;
////
////    @InjectMocks
////    private EmployeeService employeeService;
//
//	
//	
////	@Test
////	public void testAdminNotFoundException() {
////		when(adminRepository.findById(1L)).thenThrow(AdminNotFoundException.class);
////		assertThrows(AdminNotFoundException.class, () -> AdminService.getById(1L));
////		// Verify that the findById() method is called with the expected argument
////	    verify(adminRepository).findById(1L);
////
//	 
//	 
//	 
//	 
//	 @Test
//	 public void testAddAdmin() {
//	     // Create a sample adminDto for testing
//	     AdminDto adminDto = new AdminDto();
//	     adminDto.setAdminName("John Doe");
//	     adminDto.setAdminEmail("john.doe@example.com");
//	     adminDto.setAdminContact("1234567890");
//	     adminDto.setAdminAddress("123 Street, City");
//	     adminDto.setRole("ADMIN");
//	     adminDto.setPassword("password");
//
//	     // Mock the behavior of the adminRepository.getByAdminEmail() method
//	     Optional<Admin> adminOptional = Optional.empty();
//	     Mockito.when(adminRepository.getByAdminEmail(adminDto.getAdminEmail())).thenReturn(adminOptional);
//
//	     // Mock the behavior of the adminRepository.save() method
//	     Mockito.when(adminRepository.save(Mockito.any(Admin.class))).thenAnswer(invocation -> invocation.getArgument(0));
//
//	     // Create a mock userTable object
//	     UserTable userTable = new UserTable();
//	     userTable.setUserId(1L);
//	     userTable.setUserName(adminDto.getAdminEmail());
//	     userTable.setPassword(adminDto.getPassword());
//	     userTable.setUserEmail(adminDto.getAdminEmail());
//	     userTable.setRole(adminDto.getRole());
//
//	     Mockito.when(userTableRepository.save(Mockito.any(UserTable.class))).thenReturn(userTable);
//
//	     AdminDto result = adminService.addAdmin(adminDto);
//
//	     Mockito.verify(adminRepository).getByAdminEmail(adminDto.getAdminEmail());
//	     Mockito.verify(adminRepository).save(Mockito.any(Admin.class));
//	     Mockito.verify(userTableRepository).save(Mockito.any(UserTable.class));
//
//	     // Assertions
//	     assertNotNull(result);
//	     assertEquals(adminDto.getAdminName(), result.getAdminName());
//	     assertEquals(adminDto.getAdminEmail(), result.getAdminEmail());
//	     assertEquals(adminDto.getAdminContact(), result.getAdminContact());
//	     assertEquals(adminDto.getAdminAddress(), result.getAdminAddress());
//	     assertEquals(adminDto.getRole(), result.getRole());
//	}
//	
//
//}
