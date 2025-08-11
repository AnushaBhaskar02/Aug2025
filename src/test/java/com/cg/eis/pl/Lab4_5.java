package com.cg.eis.pl;
//This is the main class of Lab_4_5
import java.util.Scanner;

import com.cg.eis.bean.Employee4_5;
import com.cg.eis.service.EmployeeServiceImpl4_5;

public class Lab4_5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeServiceImpl4_5 service = new EmployeeServiceImpl4_5();

		while (true) {
			System.out.println("\n=== Employee Management System (Lab 4_5) ===");
			System.out.println("1. Add Employee");
			System.out.println("2. Delete Employee");
			System.out.println("3. Display Employees by Insurance Scheme");
			System.out.println("4. Exit");
			System.out.print("Enter choice: ");
			int choice = sc.nextInt();
			sc.nextLine(); 

			switch (choice) {
			case 1:
				System.out.print("Enter Employee ID: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Employee Name: ");
				String name = sc.nextLine();
				System.out.print("Enter Salary: ");
				double salary = sc.nextDouble();
				sc.nextLine();
				System.out.print("Enter Designation: ");
				String designation = sc.nextLine();
				System.out.print("Enter Insurance Scheme: ");
				String scheme = sc.nextLine();

				Employee4_5 emp = new Employee4_5(id, name, salary, designation, scheme);
				service.addEmployee(emp);
				System.out.println("Employee added successfully!");
				break;

			case 2:
				System.out.print("Enter Employee ID to delete: ");
				int deleteId = sc.nextInt();
				if (service.deleteEmployee(deleteId)) {
					System.out.println("Employee deleted successfully!");
				} else {
					System.out.println("Employee not found!");
				}
				break;

			case 3:
				System.out.print("Enter Insurance Scheme to search: ");
				String searchScheme = sc.nextLine();
				service.displayEmployeesByScheme(searchScheme);
				break;

			case 4:
				System.out.println("Exiting... Thank you!");
				sc.close();
				return;

			default:
				System.out.println("Invalid choice! Please try again.");
			}
		}
	}
}
