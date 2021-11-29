package com.example.employee_management_portal.model;


public class Employee {
    private int ID;
    private String name;
    private int salary;

    public Employee(int ID, String name, int salary) {
        this.ID = ID;
        this.name = name;
        this.salary = salary;
    }


    public long getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
