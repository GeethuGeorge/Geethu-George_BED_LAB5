package com.employeeManagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employeeManagement.entity.Employee;
import com.employeeManagement.repository.EmployeeRepository;
import com.employeeManagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	@Override
	public List<Employee>listEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		
		return employeeRepository.findById(id).get();		
	}

	@Override
	public void deleteById(Long id) {
		
		employeeRepository.deleteById(id);
	}
	
	//public Employee getEmployee(Employee employee)
	
	

}
