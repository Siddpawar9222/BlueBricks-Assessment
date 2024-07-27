<!DOCTYPE html>
<%@page import="com.bluebricks.dao.EmployeeDao"%>
<%@page import="java.util.Base64"%>
<%@page import="java.util.List"%>
<%@page import="com.bluebricks.entity.Employee"%>
<%@page import="com.bluebricks.dao.EmployeeDao"%>

<html lang="en">
<head>
<link rel="stylesheet" href="css/index.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Employee List</title>
<style>
</style>
</head>
<body>
	<div class="container">
		<h1>Employee List</h1>
		<%
		for (Employee employee : (List<Employee>) request.getAttribute("foundEmployees")) {
		%>
		<div class="employee-card">
			<img
				src="data:image/jpg;base64,<%=Base64.getEncoder().encodeToString(employee.getEmployeeInfo().getImage())%>"
				alt="Employee Photo">

			<div class="employee-info">
				<strong>Name:</strong>
				<%=employee.getEmployeeInfo().getName()%><br> <strong>Phone:</strong>
				<%=employee.getEmployeeInfo().getPhone()%><br> <strong>Email:</strong>
				<%=employee.getEmployeeInfo().getEmail()%><br> <strong>Address:</strong>
				<%=employee.getEmployeeInfo().getAddress()%><br> <strong>Department:</strong>
				<%=employee.getDepartment()%><br> <strong>Salary:</strong>
				<%=employee.getSalary()%><br>
			</div>
		</div>
		<%
		}
		%>
	</div>
</body>
</html>

