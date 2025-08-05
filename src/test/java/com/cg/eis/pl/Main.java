package com.cg.eis.pl;

import com.cg.eis.bean.Employee;
import com.cg.eis.service.EmployeeService;
import com.cg.eis.service.EmployeeServiceImpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeServiceImpl();

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Designation (Manager/Programmer/Clerk): ");
        String designation = sc.nextLine();

        Employee emp = new Employee(id, name, salary, designation);

        service.assignInsuranceScheme(emp);

        System.out.println("\n--- Employee Details ---");
        System.out.println(emp);
    }
}
