<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>

<html>
<head>
<link rel="stylesheet" href="/main4.css" type="text/css">

</head>
<body>
<div class="header">
<h2>Hello Hennings!

Today is:
      <%
         Date date = new Date();
         out.print( "<h2 align = \"center\">" +date.toString()+"</h2>");
      %>
</h2></div>

<div class="column side">
Task List
</div>

<div class="column middle">
Todays Calendar Events
<p>

<br/>


    <c:forEach var="calItems" items="${calendar_list}">
    <p style="color:${calItems.color}">
     <!-- <c:out value="${calItems.color}"/>
       <c:out value="${calItems.owner}"/>  -->
       <c:out value="${calItems.title}"/>
       <c:out value="${calItems.time}"/></p><p>
    </c:forEach>


</div>



<div class="column side">
Quote of the Day
<p>
 <%=request.getAttribute("quote_return")%> <p>
 ~<%=request.getAttribute("author_return")%>


    </div>

<img src="${pageContext.servletContext.contextPath}/img/Kaitlin.jpg" alt="test">
</body>
</html>