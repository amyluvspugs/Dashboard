<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" href="main2.css" type="text/css">

</head>
<body>
<h2>Hello Hennings!</h2>

<hr>
<br/>
    <c:forEach var="calItems" items="${calendar_list}">
        ${calItems.owner} <br/>

    </c:forEach>


</body>
</html>