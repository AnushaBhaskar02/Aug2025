package com.cg.eis.service;

import com.cg.eis.bean.Employee4_5;

//This is the EmployeeService interface of Lab_4_5
public interface EmployeeService4_5 {
	void addEmployee(Employee4_5 emp);
	boolean deleteEmployee(int id);
	void displayEmployeesByScheme(String scheme);
}

