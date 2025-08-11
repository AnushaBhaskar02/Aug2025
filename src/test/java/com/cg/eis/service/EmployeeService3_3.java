package com.cg.eis.service;

import com.cg.eis.bean.Employee;
import com.cg.eis.exception.EmployeeException;
//Lab3_3
public interface EmployeeService3_3 {
    void assignInsuranceScheme(Employee emp) throws EmployeeException;
    void displayEmployeeDetails(Employee emp);
}
