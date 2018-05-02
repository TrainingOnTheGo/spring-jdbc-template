package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.model.Employee;
import com.training.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {		
		return employeeRepository.findAll();
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.addEmployee(employee);
	}

	@Override
	public void editEmployee(Employee employee) {
		employeeRepository.editEmployee(employee);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteEmployee(employeeId);
		
	}

	@Override
	public Employee find(int employeeId) {
		return employeeRepository.find(employeeId);
	}
	
}
