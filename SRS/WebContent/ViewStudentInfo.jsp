<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
#header {
	background-color: black;
	color: white;
	text-align: center;
	padding: 5px;
}

#nav {
	line-height: 30px;
	background-color: #eeeeee;
	height: 400px;
	width: 200px;
	float: left;
	padding: 5px;
}

#section {
	width: 350px;
	float: left;
	padding: 10px;
}

#section1 {
	width: 350px;
	float: left;
	padding: 10px;
}

#footer {
	background-color: black;
	color: white;
	clear: both;
	text-align: center;
	padding: 5px;
}
</style>
</head>
<body>
<div id="header">
<h1>Northeastern University</h1>
</div>

<div id="nav">
<a href="ViewStudentInfo.jsp">View Student Information</a><br>
<a href="AddClass.jsp">Add/Drop Class</a><br>
<a href="ViewSchedule.jsp">View Schedule</a><br>
<a href="Login.jsp">Log Out</a><br>
</div>

<div id="section">
<br>
<form action="viewStudent" method="post">
Student Id: <input id="spanId" name="spanId" type="text">
<input type="submit" value="Submit">
</form>

</div>

<div id="footer">
Copyright � neu.edu
</div>


</body>
</html>