package org.java.jdbc.Dao;

import java.sql.SQLException;

import org.java.jdbc.model.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


public class JdbcDao {

	private JdbcTemplate jdbctemp;
	public Employee getEmp(int emp_id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{   
		String sql="select * from Employees where employee_id=?";
		return jdbctemp.queryForObject(sql, new Object[]{emp_id},new BeanPropertyRowMapper<Employee>(Employee.class));  	
	}
	
	

	public JdbcTemplate getJdbctemp() {
		return jdbctemp;
	}

	public void setJdbctemp(JdbcTemplate jdbctemp) {
		this.jdbctemp = jdbctemp;
	}
	
	

}
