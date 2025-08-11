package com.cg.eis.service;

import com.cg.eis.bean.Employee4_3;
import com.cg.eis.exception.EmployeeException4_3;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Lab4_3 - service implementation with file IO
public class EmployeeServiceImpl4_3 implements EmployeeService4_3 {

	@Override
	public void assignInsuranceScheme(Employee4_3 emp) throws EmployeeException4_3 {
		if (emp.getSalary() < 3000) {
			throw new EmployeeException4_3("Salary is below 3000. Employee not allowed.");
		}

		double s = emp.getSalary();
		String d = emp.getDesignation() == null ? "" : emp.getDesignation().trim();
		String scheme = "No Scheme";
		if (s >= 5000 && "Manager".equalsIgnoreCase(d)) scheme = "Scheme A";
		else if (s >= 3000 && s < 5000 && "Programmer".equalsIgnoreCase(d)) scheme = "Scheme B";
		else if (s < 3000 && "Clerk".equalsIgnoreCase(d)) scheme = "Scheme C";

		emp.setInsuranceScheme(scheme);
	}

	@Override
	public void displayEmployeeDetails(Employee4_3 emp) {
		System.out.println(emp);
	}

	@Override
	public void saveEmployeeToFile(Employee4_3 emp, String fileName) throws IOException {
		// Append mode
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
			bw.write(emp.toCSV());
			bw.newLine();
		}
	}

	@Override
	public List<Employee4_3> readEmployeesFromFile(String fileName) throws IOException {
		List<Employee4_3> list = new ArrayList<>();
		File f = new File(fileName);
		if (!f.exists()) return list; // no file => empty list

		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String line;
			while ((line = br.readLine()) != null) {
				Employee4_3 e = Employee4_3.fromCSV(line);
				if (e != null) list.add(e);
			}
		}
		return list;
	}
}
