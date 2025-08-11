package com.cg.eis.pl;

import java.util.Scanner;
import com.cg.eis.bean.Employee;
import com.cg.eis.service.EmployeeService;
import com.cg.eis.service.EmployeeServiceImpl;

// Lab2_3 - main class
public class Lab2_3 {
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

            EmployeeService service = new EmployeeServiceImpl();
            service.assignInsuranceScheme(emp);
            System.out.println("\n--- Employee Details ---");
            service.displayEmployeeDetails(emp);
        } finally {
            sc.close();
        }
    }
}
