<%--
  Created by IntelliJ IDEA.
  User: parkseungmin
  Date: 1/8/24
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>now</title>
</head>
<body>
<%--    <%= new Date().toString() %>--%>
<br>
now : <%= request.getAttribute("time")%>
</>
<br>
name : <%=request.getAttribute("name")%>
</>
<br>
nick name : <%=request.getAttribute("nick")%>
</>
</body>
</html>

