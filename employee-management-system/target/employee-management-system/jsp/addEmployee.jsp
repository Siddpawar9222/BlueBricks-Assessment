<!DOCTYPE html>
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
        <form action="saveEmployee" method="post" enctype="multipart/form-data">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" required>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            <label for="address">Address:</label>
            <textarea id="address" name="address" rows="3" required></textarea>
            <label for="department">Department:</label>
            <input type="text" id="department" name="department" required>
            <label for="salary">Salary:</label>
            <input type="text" id="salary" name="salary" required>
            <label for="photo">Photo:</label>
            <input type="file" id="photo" name="photo" accept="image/jpg">
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
<!-- 
request.getAttribute("id")
request.getParameter("id")
 -->