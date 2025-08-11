
package com.cg.eis.service;

import com.cg.eis.bean.Employee4_3;
import com.cg.eis.exception.EmployeeException4_3;
import java.io.IOException;
import java.util.List;

public interface EmployeeService4_3 {
    void assignInsuranceScheme(Employee4_3 emp) throws EmployeeException4_3;
    void displayEmployeeDetails(Employee4_3 emp);
    void saveEmployeeToFile(Employee4_3 emp, String fileName) throws IOException;
    List<Employee4_3> readEmployeesFromFile(String fileName) throws IOException;
}
