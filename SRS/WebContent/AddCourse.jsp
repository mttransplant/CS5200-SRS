<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="AddCourse" action="addCourse" method="post">
<table>
<tr>
<td>Course Number</td> 
<td> <input type="text" name="courseNo"></td>
</tr>
<tr>
<td>Course Title</td>
<td> <input type="text" name="courseTitle"></td>
</tr>
<tr>
<td> Course Level </td>
<td> <input type="text" name="courseLevel"></td>
</tr>
<tr>
<td> Description </td>
<td> <input type="text" name="description"> </td>
</tr>
<tr>
<td> Department </td>
<td> <input type="text" name="department"> </td>
</tr>
<tr><td style="text-align:center">
<input type="submit" value="Submit"></td></tr>
</table>
</form>
</body>
</html>
<!-- 
create table Course
	(
	id int primary key auto_increment,
	courseNumber varchar(8) unique,
	title varchar(255),
	courseLevel varchar(255),
    description longtext,
	department int,
	foreign key (department) references Department(id) 
		on update cascade on delete no action
);
 -->