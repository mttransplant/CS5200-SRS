package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentBean;
import dao.DbConnection;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");  
		StudentBean studentBean = new StudentBean();
		System.out.println("enter");
		Boolean result = false;
		studentBean.setFirstName(request.getParameter("fName"));
		studentBean.setLastName(request.getParameter("lName"));
		studentBean.setStudentId(request.getParameter("id"));
		studentBean.setAddress1(request.getParameter("address1"));
		studentBean.setAddress2(request.getParameter("address2"));
		studentBean.setAddress3(request.getParameter("address3"));
		studentBean.setCity(request.getParameter("city"));
		studentBean.setCountry(request.getParameter("country"));
		studentBean.setMajor(request.getParameter("major"));
		studentBean.setPhoneNo(request.getParameter("phone"));
		
		System.out.println("phone");
		studentBean.setLivesOnCampus(Boolean.getBoolean(request.getParameter("campus")));
		studentBean.setYearOfGraduation(Integer.parseInt(request.getParameter("year")));
		studentBean.setState(request.getParameter("state"));
		studentBean.setPostal(Long.parseLong(request.getParameter("postal")));
		studentBean.setAdvisor(Integer.parseInt(request.getParameter("advisor")));
		
		DbConnection connection = new DbConnection();
		result = connection.insertStudent(studentBean);
		if(result)
		{
			request.setAttribute("result",result);
			request.setAttribute("Successful", "Student successfully inserted.");
		}
		else
		{
			request.setAttribute("result", result);
			request.setAttribute("Failure", "Student not inserted successfully.");
		}
		request.getRequestDispatcher("/Success.jsp").forward(request, response);
		
		
		
		
	}

}
