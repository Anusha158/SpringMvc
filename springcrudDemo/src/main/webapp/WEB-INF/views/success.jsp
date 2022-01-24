<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${msg}<br>

<c:choose>
  <c:when test="${action == 'create'}">
<a href="verify/<c:out value='${student.id}'/>">verify</a> 
  </c:when>
  <c:otherwise>
  
  </c:otherwise>
</c:choose>
</body>
</html>