package com.bluebricks.entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer id;

	@Lob
	@Column(name = "employee_info", columnDefinition = "longblob")
	private byte[] employeeInfo;

	@Column(name = "employee_department", length = 64)
	private String department;

	@Column(name = "employee_salary")
	private double salary;

	public Employee() {
	}

	public Employee( EmployeeInfo employeeInfo, String department, double salary) {
		this.employeeInfo = convertEmployeeInfoToBlob(employeeInfo);
		this.department = department;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = convertEmployeeInfoToBlob(employeeInfo);
	}

	public EmployeeInfo getEmployeeInfo() {
		return convertBlobToEmployeeInfo(employeeInfo);
	}

	private byte[] convertEmployeeInfoToBlob(EmployeeInfo employeeInfo) {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baos)) {
			oos.writeObject(employeeInfo);
			return baos.toByteArray();
		} catch (IOException e) { 
			e.printStackTrace();
			return null;
		}
	}

	private EmployeeInfo convertBlobToEmployeeInfo(byte[] blob) {
		if (blob != null && blob.length > 0) {
			try (ByteArrayInputStream bais = new ByteArrayInputStream(blob);
					ObjectInputStream ois = new ObjectInputStream(bais)) {
				return (EmployeeInfo) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeInfoBlob=" + Arrays.toString(employeeInfo) + ", department="
				+ department + ", salary=" + salary + "]";
	}

}
