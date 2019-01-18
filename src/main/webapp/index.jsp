<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<html>
<head>
<link rel="stylesheet" href="/main4.css" type="text/css">
<script>
        function addEvent(obj, event, func) {
            if (obj.addEventListener) {
                obj.addEventListener(event, func, false);
                return true;
            } else if (obj.attachEvent) {
                obj.attachEvent('on' + event, func);
            } else {
                var f = obj['on' + event];
                obj['on' + event] = typeof f === 'function' ? function() {
                    f();
                    func();
                } : func
            }
        }
function updateArchive(id)
            {


                   console.log("in fn() value: " + id);
                   $.ajax({
                     url:'/updateTask',
                     type:'POST',
                     data:{"id" : id},
                   });
            }
            </script/>
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


<p>
    <c:forEach var="task" items="${tasklist_list}">

       <c:out value="${task.id}"/>
       <c:out value="${task.task}"/>
       <c:out value="${task.complete}"/>
       <c:out value="${task.archive}"/>

    <input type="checkbox" onclick="updateTaskServlet(task.id)" name="complete" id="task.id"unchecked/>


       <button id="Archive9" onclick="updateArchive('${task.id}')">THIS ONE</button>

       </p><p>
    </c:forEach>

    <br><a href="/createTask.html"><button type=\"button\">Add a Task</button></a>

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

</body>
</html>