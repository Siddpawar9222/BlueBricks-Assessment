<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error/Exception Information</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/error.css">
</head>
<body bgcolor="#f0f0f0">
    <h2>Error/Exception Information</h2>
    
    <%
        Throwable throwable = (Throwable)request.getAttribute("exception");
        Integer statusCode = (Integer)request.getAttribute("statusCode");
  
            Integer sc = (Integer)request.getAttribute("javax.servlet.error.status_code");
            String servletName = (String)request.getAttribute("javax.servlet.error.servlet_name");
            String requestUri = (String)request.getAttribute("javax.servlet.error.request_uri");
     
        if (throwable != null) {
    %>
            <p>Status Code: <%= statusCode %></p>
            <p>Exception Type: <%= throwable.getClass().getName() %></p>
            <p>The exception message: <%= throwable.getMessage() %></p>
             
            
    <%
        }else if (sc!=null) {
    %>
         
            <p>Servlet Name:<%=servletName%></p>
            <p>Exception URI:<%= requestUri %></p>
            <p>Exception URI:<%= sc %></p>   
            
    <%
        } else {
    %>
            <p>Error information not found</p>

    <%
        }
    %>
    <p>Let's go back to <a href="<%= request.getContextPath() %>">Home Page</a>.</p>
</body>
</html>
