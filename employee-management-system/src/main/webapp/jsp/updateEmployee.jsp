<!DOCTYPE html>
<%@page import="com.bluebricks.dao.EmployeeDaoImpl"%>
<%@page import="com.bluebricks.dao.EmployeeDao"%>
<%@page import="com.bluebricks.entity.Employee"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/addEmployee.css">
    <title>Add Employee</title>
</head>
<body>
    <div class="container">
        <h2>Add Employee</h2>
        <%  
        Employee employee =null ;
		String employeeIdStr = request.getParameter("id");
        if(employeeIdStr!=null){
           int emp_id = Integer.parseInt(employeeIdStr);
           employee = new EmployeeDaoImpl().getEmployeeById(emp_id);
        }
        %>
        <form action="updateEmployee" method="post" enctype="multipart/form-data">
            <input type="hidden"  name="id" value="<%= employee == null  ? "" : employee.getId() %>" required>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="<%= employee == null  ? "" : employee.getEmployeeInfo().getName() %>" required>
            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" value="<%= employee == null ? "" : employee.getEmployeeInfo().getPhone() %>" required>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="<%= employee == null ? "" : employee.getEmployeeInfo().getEmail() %>" required>
            <label for="address">Address:</label>
            <textarea id="address" name="address" rows="3" required><%= employee == null  ? "" : employee.getEmployeeInfo().getAddress() %></textarea>
            <label for="department">Department:</label>
            <input type="text" id="department" name="department" value="<%= employee != null  ? employee.getDepartment() : "" %>" required>
            <label for="salary">Salary:</label>
            <input type="text" id="salary" name="salary" value="<%= employee != null  ? employee.getSalary() : "" %>" required>
            <label for="photo">Photo:</label>
            <input type="file" id="photo" name="photo" accept="image/jpg">
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>