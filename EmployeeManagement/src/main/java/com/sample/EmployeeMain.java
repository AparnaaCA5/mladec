package com.sample;

import java.util.*;

public class EmployeeMain {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        EmployeeDao dao = new EmployeeDaoImpl();
 
        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Show All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
 
            int ch = sc.nextInt();
 
            switch (ch) {
            case 1:
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                System.out.print("Enter Name: ");
                String name = sc.next();
                System.out.print("Enter Salary: ");
                double sal = sc.nextDouble();
 
                Employee emp = new Employee(id, name, sal);
                dao.addEmployee(emp);
                System.out.println("Employee Added.");
                break;
 
            case 2:
                System.out.print("Enter ID to update: ");
                int uid = sc.nextInt();
                sc.nextLine();
 
                System.out.print("Enter New Name: ");
                String nname = sc.nextLine();
 
                System.out.print("Enter New Salary: ");
                double nsal = sc.nextDouble();
 
                Employee updated = dao.updateEmployee(new Employee(uid, nname, nsal));
                System.out.println("Employee Updated: " + updated);
                break;
 
            case 3:
                System.out.print("Enter ID to delete: ");
                int did = sc.nextInt();
                dao.deleteEmployee(did);
                System.out.println("Employee Deleted.");
                break;
 
            case 4:
                List<Employee> list = dao.getAllEmployees();
                list.forEach(System.out::println);
                break;
 
            case 5:
                System.out.println("Exiting...");
                System.exit(0);
 
            default:
                System.out.println("Invalid Choice!");
            }
        }
    }
}
 