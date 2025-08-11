package com.cg.eis.service;

import com.cg.eis.bean.Employee;
import com.cg.eis.exception.EmployeeException;

// Lab3_3 - service implementation with validation
public class EmployeeServiceImpl3_3 implements EmployeeService3_3 {

    @Override
    public void assignInsuranceScheme(Employee emp) throws EmployeeException {
        if (emp.getSalary() < 3000) {
            // business rule: salary must be >= 3000
            throw new EmployeeException("Salary is below 3000. Employee creation not allowed.");
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
    public void displayEmployeeDetails(Employee emp) {
        System.out.println(emp);
    }
}
