

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public logincontroller() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("doPost");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		LoginDAO loginDAO =new LoginDAO();
		if(loginDAO.isValidUser(username,password)==true)
		{
			PrintWriter out=response.getWriter();
		    out.println("valid user");
		RequestDispatcher dispatcher;
		dispatcher=request.getRequestDispatcher("home.html");
			dispatcher.forward(request,response);
	   
			
		}
		else
		{
		//	RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			PrintWriter writer=response.getWriter();
		    writer.println("invalid...plese try agin");
		   // dispatcher.include(request,response);

		
		}
	}

}
