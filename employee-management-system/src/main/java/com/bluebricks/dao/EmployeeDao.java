package com.bluebricks.dao;


import java.util.List;

import com.bluebricks.entity.Employee;


public interface EmployeeDao {
	public void saveEmployee(Employee employee) ;
	
	public List<Employee> getEmployees() ;
	
	public Employee getEmployeeById(int id) ;
	
	public void deleteEmployee(int id) ;
	
	public void updateEmployee(Employee employee) ;
	
	public List<Employee> getEmployeesByName(String name);

}
