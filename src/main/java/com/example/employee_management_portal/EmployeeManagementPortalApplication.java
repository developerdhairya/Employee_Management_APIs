package com.example.employee_management_portal;

import com.example.employee_management_portal.util.EmployeeDataAccess;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementPortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementPortalApplication.class, args);
        System.out.println("Run Successful");
    }
}
