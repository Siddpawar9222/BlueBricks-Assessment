package com.bluebricks.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluebricks.dao.EmployeeDao;
import com.bluebricks.dao.EmployeeDaoImpl;
import com.bluebricks.entity.Employee;

@WebServlet("/searchEmployee")
public class SearchEmployeeServlet extends HttpServlet  {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              String name = request.getParameter("name") ;
              EmployeeDao dao = new EmployeeDaoImpl();
            List<Employee> foundEmployees = dao.getEmployeesByName(name);
              
              request.setAttribute("foundEmployees", foundEmployees.size()==0 ? Arrays.asList() : foundEmployees);
              request.getRequestDispatcher("/jsp/displaySearchEmployee.jsp").forward(request, response);       
        }
}
