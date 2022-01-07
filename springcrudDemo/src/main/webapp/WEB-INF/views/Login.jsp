<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function validate(){
	var idName=document.getElementById('yn').value;
	if(Number(idName)<=0){
		alert('enter id');
		return false;
	}
	else{
		return true;
	}
	}
</script>
</head>
<body>
<div align="center">
        <h1>New/Edit Student</h1>	
        <form:form action="create" method="post" modelAttribute="student" onsubmit="return validate()">
        
        id:<form:input type="text"  id="yn" path="id"/>
       StudentName: <form:input type="text"  path="studentName"/>
       emailId:<form:input type="text"  path="emailId"/>
        <input type="submit" value="create"/>
        <a href="viewAll">viewAll</a>
     
        </form:form>
        </div>
</body>
</html>