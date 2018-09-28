<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" href="/main4.css" type="text/css">

</head>
<body>
<div class="header">
<h2>Hello Hennings!

<%

 java.util.Date today = new java.util.Date();
 System.out.println(today);
%>

Today is: "today"</h2></div>

<div class="column side">
Task List
</div>

<div class="column middle">
Todays Calendar Events


<br/>

    <c:forEach var="calItems" items="${calendar_list}">
    TITLE:
      <c:out value="${calItems.title}"/>
      Start Time:
      <c:out value="${calItems.time}"/><p>
      Owner/Description:
      <c:out value="${calItems.owner}"/><p>

    </c:forEach>
</div>

<div class="column side">
Quote of the Day
<!--
    <c:forEach var="quote" items="${quote_list}">
    Quote:
        <c:out value="${quote.quote}"/>
        <c:out value="${quote.author}"/>

    </c:forEach>
-->

    </div>


</body>
</html>