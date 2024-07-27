package com.bluebricks;

import java.util.Iterator;
import java.util.List;

import com.bluebricks.dao.EmployeeDao;
import com.bluebricks.dao.EmployeeDaoImpl;
import com.bluebricks.entity.Employee;
import com.bluebricks.entity.EmployeeInfo;

public class Main {
	public static void main(String[] args) {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		 List<Employee> employees =  employeeDao.getEmployeesByName("happy");
		 for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();	
			System.out.println(employee);
		  }
	}
}
