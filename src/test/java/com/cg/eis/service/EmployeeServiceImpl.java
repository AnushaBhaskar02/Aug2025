package com.cg.eis.service;

import com.cg.eis.bean.Employee;

// Lab2_3 - service implementation
public class EmployeeServiceImpl implements EmployeeService {

    
    @Override
    public void assignInsuranceScheme(Employee emp) {
        double s = emp.getSalary();
        String d = emp.getDesignation() == null ? "" : emp.getDesignation().trim();

        String scheme = "No Scheme";
        if (s >= 5000 && "Manager".equalsIgnoreCase(d)) {
            scheme = "Scheme A";
        } else if (s >= 3000 && s < 5000 && "Programmer".equalsIgnoreCase(d)) {
            scheme = "Scheme B";
        } else if (s < 3000 && "Clerk".equalsIgnoreCase(d)) {
            scheme = "Scheme C";
        }
        emp.setInsuranceScheme(scheme);
    }

    @Override
    public void displayEmployeeDetails(Employee emp) {
        System.out.println(emp);
    }
}
