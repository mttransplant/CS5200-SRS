package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.StudentBean;

public class DbConnection {

	public boolean insertStudent(StudentBean studentBean)
	{
		int i=0;
		Connection con = null;
		String url="jdbc:mysql://localhost:3306/";
		String dbName ="SRS";
		String userName= "root";
		String password= "swati";
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
			PreparedStatement ps=con.prepareStatement(  
					"insert into Student values(?,?,?,?,?,?,?,?,?,?,?,?)");  
			ps.setString(1, studentBean.getFirstName());
			ps.setString(2, studentBean.getLastName());
			ps.setString(3, String.valueOf(studentBean.getStudentId()));
			ps.setString(4, studentBean.getMajor());
			ps.setString(5, studentBean.getAddress1());
			ps.setString(6, studentBean.getCity());
			ps.setString(7, studentBean.getState());
			ps.setString(8, studentBean.getCountry());
			ps.setString(9, String.valueOf(studentBean.getPhoneNo()));
			ps.setString(10, String.valueOf(studentBean.getAdvisor()));
			ps.setString(11, String.valueOf(studentBean.getYearOfGraduation()));
			ps.setString(12, String.valueOf(studentBean.getPostal()));

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

}