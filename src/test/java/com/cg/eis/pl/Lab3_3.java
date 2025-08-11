package com.cg.eis.pl;

import java.util.Scanner;
import com.cg.eis.bean.Employee;
import com.cg.eis.service.EmployeeService3_3;
import com.cg.eis.service.EmployeeServiceImpl3_3;
import com.cg.eis.exception.EmployeeException;

// Lab3_3 - main class with exception handling
public class Lab3_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter employee id: ");
            int id = sc.nextInt(); sc.nextLine();

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter salary: ");
            double salary = sc.nextDouble(); sc.nextLine();

            System.out.print("Enter designation: ");
            String designation = sc.nextLine();

            Employee emp = new Employee(id, name, salary, designation);

            EmployeeService3_3 service = new EmployeeServiceImpl3_3();
            try {
                service.assignInsuranceScheme(emp); // may throw EmployeeException
                System.out.println("\n--- Employee Details ---");
                service.displayEmployeeDetails(emp);
            } catch (EmployeeException e) {
                System.err.println("Error: " + e.getMessage());
            }
        } finally {
            sc.close();
        }
    }
}
