package com.test;

//import static org.junit.jupiter.api.Assert.*;
import java.util.List;
//import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.lang.NullPointerException;


import com.sample.Employee;
import com.sample.EmployeeDao;
import com.sample.EmployeeDaoImpl;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class EmployeeDaoTest {
 
    EmployeeDao dao;
 
    @BeforeEach
    public void setup() {
        dao = new EmployeeDaoImpl();
    }
 
    
    @Test
    public void testAddEmployeePositive() {
        Employee emp = new Employee(1, "Amit", 60000);
        Employee added = dao.addEmployee(emp);
        assertEquals("Amit", added.getName());
    }
 
    
    @Test
    public void testAddEmployeeNegative() {
        assertThrows(NullPointerException.class,()->{
        	dao.addEmployee(null);
        });
     }
        
      
    
 
    
    @Test
    public void testUpdateEmployeePositive() {
        dao.addEmployee(new Employee(2, "Raj", 40000));
        Employee updated = dao.updateEmployee(new Employee(2, "Rajesh", 50000));
        assertEquals("Rajesh", updated.getName());
    }
 
    
    /*@Test
    public void testUpdateEmployeeNegative() {
        Employee result = dao.updateEmployee(new Employee(999, "Fake", 0));
        assertNull(result);
    }*/
 
    
    @Test
    public void testDeleteEmployeePositive() {
        dao.addEmployee(new Employee(3, "Karan", 35000));
        dao.deleteEmployee(3);
        List<Employee> list = dao.getAllEmployees();
        assertTrue(list.stream().noneMatch(e -> e.getId() == 3));
    }
 
    
    @Test
    public void testDeleteEmployeeNegative() {
        dao.deleteEmployee(999);  
        assertTrue(true);  
    }
 
     
    @Test
    public void testGetAllEmployeesPositive() {
        dao.addEmployee(new Employee(4, "Meera", 75000));
        List<Employee> list = dao.getAllEmployees();
        assertFalse(list.isEmpty());
    }
 
    
    @Test
    public void testGetAllEmployeesNegative() {
        List<Employee> list = dao.getAllEmployees();
        assertNotNull(list);
    }
}