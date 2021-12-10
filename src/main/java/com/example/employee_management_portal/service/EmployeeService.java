package com.example.employee_management_portal.service;
import com.example.employee_management_portal.model.Employee;
import com.example.employee_management_portal.util.EmployeeDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDataAccess employeeDataAccess;


    public List<Employee> getEmployeeList() {
        return employeeDataAccess.getEmployees();
    }

    public int addEmployee(Employee employee){
        return employeeDataAccess.addEmployees(employee);
    }

}
