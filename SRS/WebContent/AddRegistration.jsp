<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
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
		<a href="AddNewStudent.jsp">Add Student</a><br> <a
			href="AddAdvisor.jsp">Add Advisor</a><br> <a
			href="AddNewInstructor.jsp">Add Instructor</a><br> <a
			href="AddDepartment.jsp">Add Department</a><br> <a
			href="AddNewCourse.jsp">Add Course</a><br> <a
			href="AddNewRegistration.jsp">Add Registration</a><br> <a
			href="AddNewSection.jsp">Add Section</a><br> <a href="Login.jsp">Log
			Out</a><br>
	</div>

	<div id="section">
		<br>
		<form name="AddRegistration" action="addRegistration" method="post">
			<table>
				<tr>
					<td>Student</td>
					<td><select name="student">
							<%
								if (request.getAttribute("students") != null) {
									ArrayList<Integer> students = (ArrayList<Integer>) request.getAttribute("students");
									Iterator<Integer> iterator = students.iterator();
									while (iterator.hasNext()) {
										Integer student = iterator.next();
							%>
							<option value="<%=student%>"><%=student%></option>
							<%
								}
							%>
					</select> <%
 	}
 %></td>
				</tr>
				<tr>
					<td>Section</td>
					<td><select name="section">
							<%
								if (request.getAttribute("sections") != null) {
									ArrayList<Integer> sections = (ArrayList<Integer>) request.getAttribute("sections");
									Iterator<Integer> iterator = sections.iterator();
									while (iterator.hasNext()) {
										Integer section = iterator.next();
							%>
							<option value="<%=section%>"><%=section%></option>
							<%
								}
							%>
					</select> <%
 	}
 %></td>
				</tr>

				<tr>
					<td style="text-align: center"><input type="submit"
						value="Submit"></td>
				</tr>
			</table>
		</form>
		</div>

<div id="footer">
Copyright © neu.edu
</div>
</body>
</html>

<!-- create table Registration 
	(
	student int,
	foreign key (student) references Student(id) 
		on update cascade on delete cascade,
	section int,
    foreign key (section) references Section(id)
		on update cascade on delete cascade,
	grade varchar(2),
 	time_stamp timestamp,
	primary key (student, section)
); -->