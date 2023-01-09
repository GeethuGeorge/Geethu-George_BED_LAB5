package com.employeeManagement.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employeeManagement.entity.Employee;
import com.employeeManagement.service.EmployeeService;

@Controller

public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	@GetMapping("/employees")
	//http://localhost:8080/employeeManagement/employees
	public String listEmployees(Model model) {
	
	List<Employee>employees=employeeService.listEmployees();
	model.addAttribute("employees", employees);
	return "employees";
		
	}
	
	// Add Employee - START	
	@GetMapping("/employees/new")
	//http://localhost:8080/employeeManagement/employees/new
	public String addEmployeeButtonClicked(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "create_employee";
	}
	@PostMapping("/employees")
	//http://localhost:8080/employeeManagement/employees
	public String submitButtonClickedForAddEmployee(
		@ModelAttribute("employee")Employee employee) {		
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}	
	
	//update employee
	@GetMapping("/employees/edit/{id}")
	//http://localhost:8080/employeeManagement/employees/edit/2
	public String updateEmployeeButtonClicked(@PathVariable Long id,Model model) {
		Employee selectedEmployee = 
		employeeService.getEmployeeById(id);
		model.addAttribute("employee", selectedEmployee);
		return "edit_employee";
	}
	
	
	@PostMapping("/employees/{id}")
	//http://localhost:8080/employeeManagement/employees
	public String submitButtonClickedForUpdateEmployee(@PathVariable Long id,@ModelAttribute("employee")Employee employee) {
		//  Update the employee object		
		Employee existingEmployeeObj = employeeService.getEmployeeById(id);
		existingEmployeeObj.setFirstName(employee.getFirstName());
		existingEmployeeObj.setLastName(employee.getLastName());
		existingEmployeeObj.setEmail(employee.getEmail());
		employeeService.updateEmployee(employee);
		return "redirect:/employees";
	}	
	// Update Employee - End
	
		@GetMapping ("/employees/{id}")
		//http://localhost:8080/employeeManagement/employees
		public String deleteEmployee(@PathVariable Long id	) {
			employeeService.deleteById(id);
			return "redirect:/employees";
		}
	}
	
