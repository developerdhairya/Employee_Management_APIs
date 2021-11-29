package com.example.employee_management_portal.controller;

import com.example.employee_management_portal.model.Employee;
import com.example.employee_management_portal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET,path = "/getDetails")
    public List<Employee> getEmployeeList(){
        return employeeService.getEmployeeList();
    }

    @RequestMapping(method = RequestMethod.POST,path = "/addEmployee")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.DELETE,path = "/delete/{id}")
    public void deleteStudent(@PathVariable("id") int id){
        employeeService.deleteEmployee(id);
    }

}
