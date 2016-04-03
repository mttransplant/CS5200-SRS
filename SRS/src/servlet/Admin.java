package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AdminBean;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Admin() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		AdminBean adminBean = new AdminBean();
		adminBean.setUserName(request.getParameter("username"));
		adminBean.setPassword(request.getParameter("password"));
		Boolean result;
		if(adminBean.getUserName().equals("admin")&&adminBean.getPassword().equals("admin"))
		{
			result = true;
		}
		else
		{
			result = false;
		}
		if(result)
		{
			request.setAttribute("result",result);
			request.setAttribute("Successful", "Successfull login");
		}
		else
		{
			request.setAttribute("result", result);
			request.setAttribute("Failure", "Retry");
		}
		request.getRequestDispatcher("/Success.jsp").forward(request, response);
	}

	

}
