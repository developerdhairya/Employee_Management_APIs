package com.example.employee_management_portal.service;
import com.example.employee_management_portal.enities.EmployeeEntity;
import com.example.employee_management_portal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getEmployeeList() {
        return employeeRepository.findAll();
    }

    public long addEmployee(EmployeeEntity employee){
        EmployeeEntity entity=employeeRepository.save(employee);
        return entity.getID();
    }

    public int deleteEmployeeById(int id){
        if(employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return (int) employeeRepository.count();
        }
        return 0;
    }

}
