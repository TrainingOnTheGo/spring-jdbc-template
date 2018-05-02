package com.training.service;

import java.util.List;

import com.training.model.Employee;

public interface EmployeeService {

	public void addEmployee(Employee employee);
	 
    public void editEmployee(Employee employee);
 
    public void deleteEmployee(int employeeId);
 
    public Employee find(int employeeId);
 
    public List<Employee> findAll();

}