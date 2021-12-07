package com.example.employee_management_portal.util;

import com.example.employee_management_portal.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDataAccess {

    DatabaseConnectionManager databaseConnectionManager= new DatabaseConnectionManager();

    public void testDBConnectivity(){
        try{
            Connection connection=databaseConnectionManager.getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT COUNT(*) FROM employees");
            while (resultSet.next()){
                System.out.println("The output we got is " + resultSet.getString(1));
            }
        }catch (SQLException sqlException){
            System.out.println(sqlException);
        }
    }


}
