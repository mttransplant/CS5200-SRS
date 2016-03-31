<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#header {
    background-color:black;
    color:white;
    text-align:center;
    padding:5px;
}
#nav {
    line-height:30px;
    background-color:#eeeeee;
    height:300px;
    width:100px;
    float:left;
    padding:5px;	      
}
#section {
    width:350px;
    float:left;
    padding:10px;	 	 
}
#section1 {
    width:350px;
    float:left;
    padding:10px;	 	 
}
#footer {
    background-color:black;
    color:white;
    clear:both;
    text-align:center;
   padding:5px;	 	 
}
</style>
</head>
<body>
<div id="header">
<h1>Add a New Student</h1>
</div>

<div id="nav">
<a href="Add.jsp" target="_self" >Add</a><br>
<a href="View.jsp">View</a><br>
<a href="Search.jsp">Search</a><br>

</div>




<div id="section">

<form name="Add" action="abc.do" method="post">
<table>
<tr><td>
Roll No </td><td>
<input type="text" name="rollNo"></td></tr>
<tr><td>
Name</td><td>
<input type="text" name="name"></td></tr>
<tr><td style="text-align:center">
<input type="submit" value="Add"></td></tr>
</table>
</form>
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

%>

</div>

<div id="footer">
Copyright © neu.edu
</div>
</body>
</html>