<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String fname = String.valueOf(request.getAttribute("fname"));
String lname = String.valueOf(request.getAttribute("lname"));
String address1 = String.valueOf(request.getAttribute("address1"));
String address2 = String.valueOf(request.getAttribute("address2"));
String address3 = String.valueOf(request.getAttribute("address3"));
String city = String.valueOf(request.getAttribute("city"));
String postal = String.valueOf(request.getAttribute("postal"));
String state = String.valueOf(request.getAttribute("state"));
String country = String.valueOf(request.getAttribute("country"));
String phoneNo = String.valueOf(request.getAttribute("phoneNo"));
int advisor = Integer.parseInt(request.getAttribute("advisor").toString());
int yearOfGraduation = Integer.parseInt(request.getAttribute("yearOfGraduation").toString());
%>

First Name: <input type="text" value = "<%=fname %>">
<br> 
Last Name: <input type="text" value = "<%=lname %>">
<br> 
Address: Last Name: <input type="text" value = "<%=address1 %>"> 
<% if (address2 != "null")
	{%>
<input type="text" value = "<%=address2 %>">
<%} %> 
<% if (address2 != "null")
	{%>
<input type="text" value = "<%=address3 %>">
<%} %> 
<br> 
City: <input type="text" value = "<%=city %>">
<br>
State: <input type="text" value = "<%=state %>"> 
<br>
Postal: <input type="text" value = "<%=postal %>">
<br> 
Country: <input type="text" value = "<%=country %>">
<br>
Advisor:<input type="text" value = "<%=advisor %>">
<br>
Phone Number:<input type="text" value = "<%=phoneNo %>">
<br> 
Year Of Graduation:<input type="text" value = "<%=yearOfGraduation %>">

</body>
</html>