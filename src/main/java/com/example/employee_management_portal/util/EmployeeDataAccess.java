package com.example.employee_management_portal.util;

import com.example.employee_management_portal.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDataAccess {

    @Autowired
    DatabaseConnectionManager databaseConnectionManager;

//    public void testDBConnectivity(){
//        try{
//            Connection connection=databaseConnectionManager.getConnection();
//            Statement statement=connection.createStatement();
//            ResultSet resultSet=statement.executeQuery("SELECT COUNT(*) FROM employees");
//            while (resultSet.next()){
//                System.out.println("The output we got is " + resultSet.getString(1));
//            }
//        }catch (SQLException sqlException){
//            System.out.println(sqlException);
//        }
//    }

    public List<Employee> getEmployees(){
        List<Employee> employeeList=new ArrayList<>();
        try{
            Connection connection=databaseConnectionManager.getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet= statement.executeQuery("select * from employees");
            while(resultSet.next()){
                Employee employee=new Employee();
                employee.setID(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setDesignation(resultSet.getString("designation"));
                employee.setAge(resultSet.getInt("age"));
                employee.setName(resultSet.getString("name"));
                employeeList.add(employee);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return employeeList;
    }

    public int addEmployees(Employee employee){
        int rowCount=0;
        try {
            Connection connection=databaseConnectionManager.getConnection();
            String sql="INSERT INTO employees(name,gender,designation,salary,age)  VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getGender());
            preparedStatement.setString(3,employee.getDesignation());
            preparedStatement.setInt(4,employee.getSalary());
            preparedStatement.setInt(5,employee.getAge());
            rowCount=preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return rowCount;
    }


}
