package com.cg.eis.pl;

import java.util.List;
import java.util.Scanner;
import com.cg.eis.bean.Employee4_3;
import com.cg.eis.service.EmployeeService4_3;
import com.cg.eis.service.EmployeeServiceImpl4_3;
import com.cg.eis.exception.EmployeeException4_3;
import java.io.File;

// Lab4_3 - main class that also writes/reads file
public class Lab4_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fileName = "employees.txt"; // saved in current working directory
		try {
			System.out.print("Enter employee id: ");
			int id = sc.nextInt(); sc.nextLine();

			System.out.print("Enter name: ");
			String name = sc.nextLine();

			System.out.print("Enter salary: ");
			double salary = sc.nextDouble(); sc.nextLine();

			System.out.print("Enter designation: ");
			String designation = sc.nextLine();

			Employee4_3 emp = new Employee4_3(id, name, salary, designation);

			EmployeeService4_3 service = new EmployeeServiceImpl4_3();
			try {
				service.assignInsuranceScheme(emp); // validate + assign scheme
				System.out.println("\nAssigned scheme and details:");
				service.displayEmployeeDetails(emp);

				// Save to file
				service.saveEmployeeToFile(emp, fileName);
				System.out.println("\nEmployee saved to file: " + new File(fileName).getAbsolutePath());

				// Read all employees from file and display
				System.out.println("\n--- Employees read from file ---");
				List<Employee4_3> all = service.readEmployeesFromFile(fileName);
				if (all.isEmpty()) {
					System.out.println("No employee records found in file.");
				} else {
					for (Employee4_3 e : all) {
						service.displayEmployeeDetails(e);
					}
				}
			} catch (EmployeeException4_3 ex) {
				System.err.println("Business rule violation: " + ex.getMessage());
			} catch (Exception ex) {
				System.err.println("Error: " + ex.getMessage());
				ex.printStackTrace();
			}
		} finally {
			sc.close();
		}
	}
}
