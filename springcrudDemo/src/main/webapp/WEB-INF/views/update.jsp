<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form action="updatebyid" method="post" modelAttribute="student" border="0">
    <c:forEach var="student" items="${listStudent}" >
        id:<input type="text"  value="${student.id }" name="id" >
       StudentName: <input type="text" value="${student.studentName}" name="StudentName">
       emailId:<input type="text" value="${student.emailId}" name="emailId">
        <input type="submit" >
        </c:forEach>
        
</form>
</body>
</html>