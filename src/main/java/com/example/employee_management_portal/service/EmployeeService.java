package com.example.employee_management_portal.service;

import com.example.employee_management_portal.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employeeList=new ArrayList<>(Arrays.asList(new Employee(1,"Naman",500),new Employee(1,"Naman",50000),new Employee(2,"Nitika",52000)));

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addEmployee(Employee employee){
        if(employee.getName()!=""){
            employeeList.add(employee);
        }
    }

    public void deleteEmployee(int id){
        employeeList.remove(id);
    }

}
