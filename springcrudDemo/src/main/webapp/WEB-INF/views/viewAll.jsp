<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table  >
<tr><a href="Login.jsp">Click for Create</a></tr>
<tr>
<th>Id</th>
<th>StudentName</th>
<th>EmailId</th>
</tr>
<c:forEach  var="student" items="${list}">
<tr>
<td>${student.id}</td>
<td>${student.studentName}</td>
<td>${student.emailId}  </td><td>  </td>
<td><a href="update/<c:out value='${student.id}'/>">Update</a> | <a
					href="delete/<c:out value='${student.id}'/>">Delete</a></td>
</tr>


		</c:forEach>			
</table>


</body>
</html>