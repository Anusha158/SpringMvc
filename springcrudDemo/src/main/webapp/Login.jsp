<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
        <h1>New/Edit Student</h1>
        <form action="create" method="post" modelAttribute="student">
        
        id:<input type="text"  name="id">
       StudentName: <input type="text"  name="StudentName">
       emailId:<input type="text"  name="emailId">
        <input type="submit">
        <a href="viewAll">viewAll</a>
     
        </form>
        </div>
</body>
</html>