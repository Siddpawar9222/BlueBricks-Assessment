package com.bluebricks.controller;


import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bluebricks.dao.EmployeeDao;
import com.bluebricks.dao.EmployeeDaoImpl;
import com.bluebricks.entity.Employee;
import com.bluebricks.entity.EmployeeInfo;
import com.bluebricks.util.ImageUtil;

@WebServlet("/jsp/saveEmployee")
@MultipartConfig
public class SaveEmployeeServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String department = request.getParameter("department");
			double salary = Double.parseDouble(request.getParameter("salary"));
			Part imgPart =   request.getPart("photo");
			byte[] imgaData = ImageUtil.imgToByte(imgPart);
            
			EmployeeInfo employeeInfo = new EmployeeInfo(name, phone, email, address, imgaData);
			Employee employee = new Employee(employeeInfo, department, salary);
			EmployeeDao dao = new EmployeeDaoImpl();
			dao.saveEmployee(employee);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
	}
}
