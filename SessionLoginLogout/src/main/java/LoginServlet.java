import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		
		if(pass.equals("admin"))
		{
			out.println("<b>you are logged in </b>");
			out.println("<br> Welcome, "+name);
			RequestDispatcher rd = req.getRequestDispatcher("link.html");
			rd.include(req, res);
			
			HttpSession ses = req.getSession();
			ses.setAttribute("name", name);
		}
		else
		{
			out.println("<b>Username or password Error !!</b>");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
	}
}
