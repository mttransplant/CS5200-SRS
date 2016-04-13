package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import bean.AdminBean;
import bean.StudentBean;
import bean.InstructorBean;
import bean.RosterBean;

public class DbConnection {

	ArrayList<Integer> advisors = new ArrayList<Integer>();
	ArrayList<Integer> majors = new ArrayList<Integer>();
	AdminBean adminBean = new AdminBean();
	public boolean insertStudent(StudentBean studentBean)
	{
		int i=0;
		long UUId;
		int auto = 0;
		Connection con = null;
		String url="jdbc:mysql://localhost:3306/";
		String dbName ="SRS";
		String userName= adminBean.getUserName();
		String password= adminBean.getPassword();
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url+dbName,userName,password);
			System.out.println("Connected to the database");

			/*	INSERT INTO `srs`.`Student` (`fName`, `lName`, `sID`, `major`, `address1`, `city`, `state`, 
					`country`, `phoneNumber`, `advisor`, `yearOfGraduation`,`postalCode`) VALUES ('Ralph', 
							'Holmes', '57863610', '4', '499 Central Avenue', 'Wayne', 'NJ', 'US', 
							'6175551242', '4', '2016','07470');
			 */
			
			/*create table Student 
	(
	id int primary key auto_increment,
	fName varchar(255) not null,
	lName varchar(255) not null,
	schoolID char(8) not null,
    email varchar(255) unique,
	major integer,
	foreign key (major) references Department(id)
		on update cascade on delete set null,
	address1 varchar(255) not null,
	address2 varchar(255),
	address3 varchar(255),
	city varchar(255) not null,
	state varchar(255) not null,
    postalCode varchar(10) not null,
	country varchar(255) not null,
	phoneNumber varchar(15),
	advisor int,
	foreign key (advisor) references Advisor(id)
		on update cascade on delete set null,
	yearOfGraduation integer,
	livesOncampus enum('No','Yes') not null,
    username varchar(255) unique
	);*/
			PreparedStatement ps=con.prepareStatement(  
					"insert into Student (fName,lName,email,major,address1, "+
											"address2, address3, city, state,"+ 
					"postalCode,country, phoneNumber, advisor, yearOfGraduation,livesOncampus)"+
							"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");  
			
			ps.setString(1, studentBean.getFirstName());
			ps.setString(2, studentBean.getLastName());
			ps.setString(3, studentBean.getEmail());
			ps.setInt(4, Integer.parseInt(studentBean.getMajor()));
			ps.setString(5, studentBean.getAddress1());
			ps.setString(6, studentBean.getAddress2());
			ps.setString(7, studentBean.getAddress3());
			ps.setString(8, studentBean.getCity());
			ps.setString(9, studentBean.getState());
			ps.setString(10, String.valueOf(studentBean.getPostal()));
			ps.setString(11, studentBean.getCountry());
			ps.setString(12, String.valueOf(studentBean.getPhoneNo()));
			ps.setInt(13, Integer.parseInt(studentBean.getAdvisor()));
			ps.setString(14, String.valueOf(studentBean.getYearOfGraduation()));
			ps.setString(15, studentBean.isLivesOnCampus());

			i=ps.executeUpdate();  

		}
		catch (SQLException e2) {
			e2.printStackTrace();
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}   
		finally
		{
			try {

				con.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		if(i>0)  
			return true;
		else
			return false;
	}  

	public ArrayList<Integer> getAdvisor()
	{
		
		Connection con = null;
		String url="jdbc:mysql://localhost:3306/";
		String dbName ="SRS";
		String userName= adminBean.getUserName();
		String password= adminBean.getPassword();
		
		try
		{

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url+dbName,userName,password);
			System.out.println("Connected to the database");

			PreparedStatement statement = con.prepareStatement("select id from Advisor");
			ResultSet rs = (ResultSet) statement.executeQuery();
			
			while(rs.next())
			{
				advisors.add(rs.getInt(1));
				System.out.println("Advisor: " + rs.getInt(1));
			}
			
			statement.close();
		}
		catch (SQLException e2) {
			e2.printStackTrace();
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {

			e.printStackTrace();
		}   
		finally
		{
			try {

				con.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return advisors;
	}
	public ArrayList<Integer> getDepartment()
	{
		
		Connection con = null;
		String url="jdbc:mysql://localhost:3306/";
		String dbName ="SRS";
		String userName= adminBean.getUserName();
		String password= adminBean.getPassword();
		
		try
		{

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url+dbName,userName,password);
			System.out.println("Connected to the database");

			PreparedStatement statement = con.prepareStatement("select id from Department");
			ResultSet rs = (ResultSet) statement.executeQuery();
			
			while(rs.next())
			{
				majors.add(rs.getInt(1));
				System.out.println("Department: " + rs.getInt(1));
			}
			
			statement.close();
		}
		catch (SQLException e2) {
			e2.printStackTrace();
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {

			e.printStackTrace();
		}   
		finally
		{
			try {

				con.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return majors;
	}
	
	public StudentBean viewStudentInfo(String id)
	{
		//int i=0;
		Connection con = null;
		String url="jdbc:mysql://localhost:3306/";
		String dbName ="SRS";
		String userName= "root";
		String password= "Mishu123!";
		StudentBean sbean = new StudentBean();
		String fName="";
		String lName = "";
		String address1="";
		String address2="";
		String address3="";
		String city="";
		String state="";
		String country="";
		String phoneNo = "";
		int yearOfGraduation = 0;
		int advisor= 0;
		String major="";	
		
		
		//String sID = "";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url+dbName,userName,password);
			//System.out.println("Connected to the databse");
			PreparedStatement ps=con.prepareStatement( "select * from Student where sID=?");  
			
			ps.setString(1, id);
			
			ResultSet rs = (ResultSet) ps.executeQuery();
			
			//while (rs.next()) {
			if(rs.next()){	
				fName = rs.getString("fName");
				 lName = rs.getString("lName");
				 address1=rs.getString("address1");
				 address2=rs.getString("address2");
				 address3=rs.getString("address3");
				 city=rs.getString("city");
				 state=rs.getString("state");
				 country=rs.getString("country");
				 major=rs.getString("major");
				 phoneNo=rs.getString("phoneNumber");
				 advisor=rs.getInt("advisor");
				 yearOfGraduation=rs.getInt("yearOfGraduation");
				 major=rs.getString("major");
				 
		     //sID = rs.getString("sID");			}
			//int b = rs.getInt("age");
			
			//request.setAttribute("first",fName);
		     
			}
			
			sbean.setFirstName(fName);
			sbean.setLastName(lName);
			sbean.setAddress1(address1);
			sbean.setAddress2(address2);
			sbean.setAddress3(address3);
			sbean.setCity(city);
			sbean.setState(state);
			sbean.setAdvisor(String.valueOf(advisor));
			sbean.setMajor(major);
			sbean.setCountry(country);
			sbean.setPhoneNo(phoneNo);
			sbean.setYearOfGraduation(yearOfGraduation);
			
			//i=ps.executeUpdate();  
			rs.close();
		      ps.close();
		      con.close();
		      
		      
			
		}
		catch (SQLException e2) {
			e2.printStackTrace();
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}   
		finally
		{
			try {

				con.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
//		if(i>0)  
//			return true;
//		else
//			return false;
		return sbean;
	}  

	public ArrayList<RosterBean> viewRoster(InstructorBean instructor) {
		
		Connection con = null;
		String url="jdbc:mysql://localhost:3306/";
		String dbName ="SRS";
		String username = instructor.getUsername();
		String password = instructor.getPassword();
		ArrayList<RosterBean> roster = new ArrayList<RosterBean>();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url+dbName,username,password);
			
			PreparedStatement ps=con.prepareStatement( "select * from InstructorRoster");  
			
			ResultSet rs = (ResultSet) ps.executeQuery();
			
			while(rs.next()) {
				RosterBean entry = new RosterBean();
				entry.setSectionID(rs.getInt("sectionID"));
				entry.setCourseNumber(rs.getString("courseNumber"));
				entry.setTitle(rs.getString("title"));
				entry.setSemester(rs.getString("semester"));
				entry.setStudentID(rs.getString("studentID"));
				entry.setStudentFN(rs.getString("studentFN"));
				entry.setStudentLN(rs.getString("studentLN"));
				entry.setStudentMajor(rs.getString("studentMajor"));
				entry.setStudentGrade(rs.getString("studentGrade"));
				entry.setInstructorFN(rs.getString("instructorFN"));;
				entry.setInstructorLN(rs.getString("instructorLN"));
				
				roster.add(entry);
			}
			
			
			
			rs.close();
		    ps.close();
			
		   
		    
		}
		catch (SQLException e2) {
			e2.printStackTrace();
		} 
		catch (InstantiationException e) {
			e.printStackTrace();
		} 
		catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}   	
		finally	{
			try {
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return roster;
	}
}
