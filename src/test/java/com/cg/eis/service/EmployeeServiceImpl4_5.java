package com.cg.eis.service;

//This is the EmployeeServiceImpl class of Lab_4_5
import java.util.HashMap;
import java.util.Map;

import com.cg.eis.bean.Employee4_5;

public class EmployeeServiceImpl4_5 implements EmployeeService4_5 {
	HashMap<Integer, Employee4_5> list = new HashMap<>();

	@Override
	public void addEmployee(Employee4_5 emp) {
		list.put(emp.getId(), emp);
	}

	@Override
	public boolean deleteEmployee(int id) {
		if (list.containsKey(id)) {
			list.remove(id);
			return true;
		}
		return false;
	}

	@Override
	public void displayEmployeesByScheme(String scheme) {
		boolean found = false;
		for (Map.Entry<Integer, Employee4_5> entry : list.entrySet()) {
			if (entry.getValue().getInsuranceScheme().equalsIgnoreCase(scheme)) {
				System.out.println(entry.getValue());
				found = true;
			}
		}
		if (!found) {
			System.out.println("No employees found for scheme: " + scheme);
		}
	}
}
