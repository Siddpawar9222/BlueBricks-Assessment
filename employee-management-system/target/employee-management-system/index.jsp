<!DOCTYPE html>
<%@page import="com.bluebricks.dao.EmployeeDaoImpl"%>
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
	 
	 <div class="navbar">
    <a href="jsp/addEmployee.jsp">Add Employee</a> 
    <form action="searchEmployee" method="GET">
        <input type="text" name="name" placeholder="Search Employee">
        <button type="submit">Search</button>
    </form>
</div>
	 
	 
	<div class="container">
		<h1>Employee List</h1>
		<%
		for (Employee employee : new EmployeeDaoImpl().getEmployees()) {
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
			<div class="btn-group">
				<button class="btn btn-edit"
					onclick="editEmployee(<%=employee.getId()%>)">Edit</button>
				<button class="btn btn-delete"
					onclick="deleteEmployee(<%=employee.getId()%>)">Delete</button>
			</div>
		</div>
		<%
		}
		%>
	</div>

	<script>
        function editEmployee(employeeId) {
            window.location.href = "jsp/updateEmployee.jsp?id=" + employeeId;
        }

        function deleteEmployee(employeeId) {
            if (confirm("Are you sure you want to delete this employee?")) {
                window.location.href = "deleteEmployee?id=" + employeeId;
            }
        }
    </script>
</body>
</html>

