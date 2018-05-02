package com.training.configuration;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.training.model.Employee;

public class CustomRowMapper implements RowMapper<Employee>
{
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEmpId(rs.getInt("EMP_ID"));
		employee.setName(rs.getString("NAME"));
		employee.setSalary(rs.getString("SALARY"));
		return employee;
	}	
}