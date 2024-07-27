package com.bluebricks.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bluebricks.entity.Employee;
import com.bluebricks.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	
	public void saveEmployee(Employee employee) {
		Transaction transaction = null;
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        try {
	            transaction = session.beginTransaction();
	            session.save(employee);
	            transaction.commit();
	        } catch (Exception e) {
	        	if (transaction != null) {
					transaction.rollback();
				}
	            throw e; 
	        }
	    }
	}

	public List<Employee> getEmployees() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Employee", Employee.class).list();
		}
	}

	public Employee getEmployeeById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Employee employee = session.createQuery("from Employee where id=" + id, Employee.class).getSingleResult();
			return employee;
		}
	}

	public void deleteEmployee(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Employee employee = session.get(Employee.class, id);
			transaction = session.beginTransaction();
			session.delete(employee);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw e;
		}
	}

	public void updateEmployee(Employee employee) {
		Transaction transaction = null;
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        try {
	            transaction = session.beginTransaction();
	            session.update(employee);
	            transaction.commit();
	        } catch (Exception e) {
	        	if (transaction != null) {
					transaction.rollback();
				}
	            throw e; 
	        }
	    }
	}

	public List<Employee> getEmployeesByName(String name) {
		List<Employee> employees = new ArrayList<>();
		for (Employee employee : getEmployees()) {
			if (employee.getEmployeeInfo().getName().trim().equalsIgnoreCase(name)) {
				employees.add(employee);
			}
		}
		return employees;
	}

}
