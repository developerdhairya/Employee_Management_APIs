package com.example.employee_management_portal.controller;

import com.example.employee_management_portal.model.Employee;
import com.example.employee_management_portal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET,path = "/getDetails")
    public ResponseEntity<List<Employee>> getEmployeeList(){
        return new  ResponseEntity<List<Employee>>(employeeService.getEmployeeList(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,path = "/addEmployee")
    public ResponseEntity<Integer> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Integer>(employeeService.addEmployee(employee),HttpStatus.OK);
    }
//
//    @RequestMapping(method = RequestMethod.DELETE,path = "/delete/{id}")
//    public void deleteStudent(@PathVariable("id") int index) {
//        employeeService.deleteEmployee(index);
//    }
}
