package com.bluebricks.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluebricks.dao.EmployeeDao;
import com.bluebricks.dao.EmployeeDaoImpl;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
		String employeeIdStr = request.getParameter("id");
        int employeeId = Integer.parseInt(employeeIdStr);
        EmployeeDao dao = new EmployeeDaoImpl();
		dao.deleteEmployee(employeeId);
		response.sendRedirect(request.getContextPath() + "/index.jsp");

	}
}
