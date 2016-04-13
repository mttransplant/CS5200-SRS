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
		<a href="AdvisorNewRegistration.jsp">Add Registration</a><br> <a
			href="ViewTranscript.jsp">View Transcript</a><br> <a
			href="ViewStudentInformation.jsp">View Student Information</a><br>
		<a href="Login.jsp">Log Out</a><br>
	</div>

	<div id="section">
		<br>
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
		<table border="1">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Address</th>
				<th>City</th>
				<th>State</th>
				<th>Postal</th>
				<th>Country</th>
				<th>Advisor</th>
				<th>Phone Number</th>
				<th>Year of Graduation</th>
			</tr>

			<tr>
				<td><%=fname%></td>
				<td><%=lname%>"</td>
				<td><%=address1%> <%
 	if (address2 != "null") {
 %> <%=address2%> <%
 	}
 %> <%
 	if (address2 != "null") {
 %> <%=address3%> <%
 	}
 %></td>
				<td><%=city%></td>
				<td><%=state%></td>
				<td><%=postal%></td>
				<td><%=country%></td>
				<td><%=advisor%></td>
				<td><%=phoneNo%></td>
				<td><%=yearOfGraduation%></td>
			</tr>
		</table>
	</div>
	<div id="footer">Copyright © neu.edu</div>
</body>
</html>