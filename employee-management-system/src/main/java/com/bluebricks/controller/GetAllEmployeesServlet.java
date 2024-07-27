package com.bluebricks.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluebricks.dao.EmployeeDao;
import com.bluebricks.dao.EmployeeDaoImpl;
import com.bluebricks.entity.Employee;



@WebServlet("/getUsers")
public class GetAllEmployeesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDao dao = new EmployeeDaoImpl();
        List<Employee> employees = dao.getEmployees();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}