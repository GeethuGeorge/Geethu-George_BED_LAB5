package com.employeeManagement.service;

import java.util.List;


import com.employeeManagement.entity.Employee;

public interface EmployeeService {
	
	List<Employee>listEmployees();
	
	Employee saveEmployee(Employee employee);
	
	//update start
	
	Employee updateEmployee(Employee employee);
	
	Employee getEmployeeById(Long id);
	//update end
	void deleteById(Long id);
	
}
