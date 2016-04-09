package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import bean.AdminBean;
import bean.StudentBean;

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

}