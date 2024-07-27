package com.bluebricks.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class ExceptionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
        	int statusCode =  getStatusCode(t);
        	request.setAttribute("statusCode", statusCode);
            request.setAttribute("exception", t);
            request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }
    
    private int getStatusCode(Throwable t) {
    	if (t instanceof NumberFormatException) {
            return HttpServletResponse.SC_BAD_REQUEST;
        }else {
            return HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
        }
    }
       
}
