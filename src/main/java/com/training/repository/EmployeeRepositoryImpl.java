package com.training.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.training.model.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	/* (non-Javadoc)
	 * @see com.training.repository.EmployeeRepository#findAll()
	 */
	
	@Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public void addEmployee(Employee employee) {
		jdbcTemplate.update("INSERT INTO employee (emp_id, name, salary) VALUES (?, ?, ?)",
				employee.getEmpId(), employee.getName(), employee.getSalary());
	        System.out.println("Employee Added!!");
		
	}

	@Override
	public void editEmployee(Employee employee) {
		jdbcTemplate.update("UPDATE employee SET name = ? , salary = ? WHERE emp_id = ? ",
				employee.getName(), employee.getSalary(), employee.getEmpId());
	    System.out.println("Employee Updated!!");
	}

	@Override
	public void deleteEmployee(int employeeId) {
		jdbcTemplate.update("DELETE from employee WHERE emp_id = ? ", employeeId);
        System.out.println("Employee Deleted!!");
		
	}

	@Override
	public Employee find(int employeeId) {
		Employee employee = (Employee) jdbcTemplate.queryForObject("SELECT * FROM employee where emp_id = ? ",
	            new Object[] { employeeId }, new BeanPropertyRowMapper<>(Employee.class));
	        return employee;
	}
	
	@Override
	public List<Employee> findAll() {
		List <Employee> employees = jdbcTemplate.query("SELECT * FROM employee", new BeanPropertyRowMapper(Employee.class));
        return employees;
	}
}
