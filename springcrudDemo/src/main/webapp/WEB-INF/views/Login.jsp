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
<style type="text/css">
.error{
color:red;
positon:fixed;

}
	
</style>
</head>
<body>
<div align="center">
        <h1>New/Edit Student</h1>	
        <form:form action="create" method="post" modelAttribute="student" onsubmit="return validate()">
        
        id:<form:input type="text"  id="yn" path="id"/><form:errors path="id"/><br/>
       StudentName: <form:input type="text"  path="studentName"/><form:errors path="studentName" class="error"/><br/>
       Age<form:input type="text"  path="age"/><form:errors path="age" class="error"/><br/>
       emailId:<form:input type="text"  path="communicationDTO.emailId"/><form:errors path="communicationDTO.emailId" class="error"/><br/>
       phone :<form:input type="text"  path="communicationDTO.phone"/><form:errors path="communicationDTO.phone" class="error"/>
        <input type="submit" value="create"/><br/>
        <a href="viewAll">viewAll</a><br/>
     
        </form:form>
        </div>
</body>
</html>