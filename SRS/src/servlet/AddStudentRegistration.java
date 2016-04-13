package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbConnection;

/**
 * Servlet implementation class AddRegistration
 */
@WebServlet("/AddStudentRegistration")
public class AddStudentRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		DbConnection connection = new DbConnection();
		//ArrayList<Integer> students = connection.getStudent();
		ArrayList<Integer> sections = connection.getSection();
		//request.setAttribute("students", students);
		request.setAttribute("sections", sections);
		request.getRequestDispatcher("/AddStudentRegistration.jsp").forward(request, response);
	}
/*create table Registration 
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
); */
}
