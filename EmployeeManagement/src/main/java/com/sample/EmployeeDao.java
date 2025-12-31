package com.sample;

import java.util.List;

public interface EmployeeDao {
 
    public Employee addEmployee(Employee emp);
 
    public Employee updateEmployee(Employee emp);
 
    public void deleteEmployee(int id);
 
    public List<Employee> getAllEmployees();
}