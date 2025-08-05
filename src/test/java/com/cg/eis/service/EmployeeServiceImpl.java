package com.cg.eis.service;

import com.cg.eis.bean.Employee;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void assignInsuranceScheme(Employee emp) {
        double salary = emp.getSalary();
        String desig = emp.getDesignation();

        if (salary >= 40000 && desig.equalsIgnoreCase("Manager")) {
            emp.setInsuranceScheme("Scheme A");
        } else if (salary >= 20000 && desig.equalsIgnoreCase("Programmer")) {
            emp.setInsuranceScheme("Scheme B");
        } else if (salary >= 5000 && desig.equalsIgnoreCase("Clerk")) {
            emp.setInsuranceScheme("Scheme C");
        } else {
            emp.setInsuranceScheme("No Scheme");
        }
    }
}
