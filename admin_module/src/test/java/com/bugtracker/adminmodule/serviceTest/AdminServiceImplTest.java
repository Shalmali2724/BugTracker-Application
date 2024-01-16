//package com.bugtracker.adminmodule.serviceTest;
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.web.client.RestTemplate;
//
//import com.bugtracker.adminmodule.dto.AdminDto;
//import com.bugtracker.adminmodule.dto.AssignDto;
//import com.bugtracker.adminmodule.dto.Employee;
//import com.bugtracker.adminmodule.dto.Project;
//import com.bugtracker.adminmodule.entity.Admin;
//import com.bugtracker.adminmodule.entity.UserTable;
//import com.bugtracker.adminmodule.exception.AdminAuthenticationFailureException;
//import com.bugtracker.adminmodule.exception.AdminNotFoundException;
//import com.bugtracker.adminmodule.repository.AdminRepository;
//import com.bugtracker.adminmodule.repository.UserTableRepository;
//import com.bugtracker.adminmodule.service.AdminServiceImpl;
//
//public class AdminServiceImplTest {
//
//    @Mock
//    private RestTemplate restTemplate;
//
//    @Mock
//    private AdminRepository adminRepository;
//
//    @Mock
//    private UserTableRepository userTableRepository;
//
//    @InjectMocks
//    private AdminServiceImpl adminService;
//
//    @Before
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testAddAdmin() {
//        AdminDto adminDto = new AdminDto();
//        adminDto.setAdminName("John");
//        adminDto.setAdminEmail("john@example.com");
//        adminDto.setAdminContact("1234567890");
//        adminDto.setAdminAddress("123 Main St");
//        adminDto.setRole("ROLE_ADMIN");
//        adminDto.setPassword("password");
//
//        when(adminRepository.getByAdminEmail(adminDto.getAdminEmail())).thenReturn(Optional.empty());
//
//        String result = adminService.addAdmin(adminDto);
//
//        assertEquals("Admin Save Successfully", result);
//        verify(adminRepository).save(any(Admin.class));
//        verify(userTableRepository).save(any(UserTable.class));
//    }
//
//    @Test(expected = AdminAuthenticationFailureException.class)
//    public void testAddAdminWithExistingEmail() {
//        AdminDto adminDto = new AdminDto();
//        adminDto.setAdminEmail("john@example.com");
//
//        when(adminRepository.getByAdminEmail(adminDto.getAdminEmail())).thenReturn(Optional.of(new Admin()));
//
//        adminService.addAdmin(adminDto);
//    }
//
//    @Test
//    public void testDoLogin() {
//        String userName = "john@example.com";
//        String password = "password";
//        String role = "ROLE_ADMIN";
//
//        UserTable userTable = new UserTable();
//        userTable.setPassword(password);
//        userTable.setUserName(userName);
//        userTable.setRole(role);
//
//        Admin admin = new Admin();
//
//        when(userTableRepository.login(userName, password, role)).thenReturn(Optional.of(userTable));
//        when(adminRepository.getByAdminEmail(userName)).thenReturn(Optional.of(admin));
//
//        Admin result = adminService.doLogin(userName, password, role);
//
//        assertEquals(admin, result);
//    }
//
//    @Test(expected = AdminNotFoundException.class)
//    public void testDoLoginWithInvalidCredentials() {
//        String userName = "john@example.com";
//        String password = "password";
//        String role = "ROLE_ADMIN";
//
//        when(userTableRepository.login(userName, password, role)).thenReturn(Optional.empty());
//
//        adminService.doLogin(userName, password, role);
//    }
//
//    
//}
////    @Test(expected = AdminAuthenticationFailureException.class)
////    public void testDoLoginWithIncorrectCredentials() {
////        String userName = "john@example.com";
////        String password = "password";
////        String role = "ROLE_ADMIN";
////
////        UserTable userTable = new UserTable
