package com.sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
 
public class EmployeeDaoImpl implements EmployeeDao {
 
    private Connection con;
    private List<Employee> localData = new ArrayList<>(); 
 
    public EmployeeDaoImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
 
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employee_db",
                "root",
                "root@39"
            );
 
            System.out.println("MySQL Connected Successfully!");
 
           
            String createTableSQL =
                "CREATE TABLE IF NOT EXISTS employee (" +
                "id INT PRIMARY KEY, " +
                "name VARCHAR(50), " +
                "salary DOUBLE" +
                ")";
            
            Statement stmt = con.createStatement();
            stmt.execute(createTableSQL);
            System.out.println("Table 'employee' verified/created.");
 
        } catch (Exception e) {
            System.out.println("MySQL not connected");
            e.printStackTrace();
            con = null;
        }
    }
 
    @Override
    public Employee addEmployee(Employee emp) {
    	if(emp==null) {
    		throw new NullPointerException("Employee cannot be null");
    	}
        if (con == null) {
            localData.add(emp);
            return emp;
        }
 
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO employee VALUES (?,?,?)");
            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setDouble(3, emp.getSalary());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }
 
    @Override
    public Employee updateEmployee(Employee emp) {
    	if(emp==null) {
    		throw new NullPointerException("Employee cannot be null");
    	}
        if (con == null) {
            for (Employee e : localData) {
                if (e.getId() == emp.getId()) {
                    e.setName(emp.getName());
                    e.setSalary(emp.getSalary());
                    return e;
                }
            }
            return null;
        }
 
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE employee SET name=?, salary=? WHERE id=?");
            ps.setString(1, emp.getName());
            ps.setDouble(2, emp.getSalary());
            ps.setInt(3, emp.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }
 
    @Override
    public void deleteEmployee(int id) {
        if (con == null) {
            localData.removeIf(e -> e.getId() == id);
            return;
        }
 
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    @Override
    public List<Employee> getAllEmployees() {
        if (con == null) {
            return localData;
        }
 
        List<Employee> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employee");
 
            while (rs.next()) {
                list.add(new Employee(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDouble(3)
                ));
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
 