<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<a href="AdvisorNewRegistration.jsp">Add Registration</a><br>
<a href="ViewTranscript.jsp">View Transcript</a><br>
<a href="AdvisorStudentInformation.jsp">View Student Information</a><br>
<a href="Login.jsp">Log Out</a><br>
</div>

<div id="section">
<br>
<%
if(request.getAttribute("Successful")!=null)
{
	out.println(request.getAttribute("Successful"));
}
if(request.getAttribute("Failure")!=null)
{
	out.println(request.getAttribute("Failure"));
}
if(request.getAttribute("SuccessfulRegistration")!=null)
{
	out.println(request.getAttribute("SuccessfulRegistration"));
}
if(request.getAttribute("FailureRegistration")!=null)
{
	out.println(request.getAttribute("FailureRegistration"));
}

%>

</div>

<div id="footer">
Copyright © neu.edu
</div>
</body>
</html>