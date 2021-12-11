package com.example.employee_management_portal.controller;

import com.example.employee_management_portal.enities.EmployeeEntity;
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
    public ResponseEntity<List<EmployeeEntity>> getEmployeeList(){
        return new  ResponseEntity<List<EmployeeEntity>>(employeeService.getEmployeeList(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,path = "/addEmployee")
    public ResponseEntity<Long> addEmployee(@RequestBody EmployeeEntity employee) {
        return new ResponseEntity<Long>(employeeService.addEmployee(employee),HttpStatus.OK);
    }

    @DeleteMapping(path = "deleteEmployee/{id}")
    public int deleteEmployeeByID(@PathVariable("id") int id ){
        return employeeService.deleteEmployeeById(id);
    }

}
