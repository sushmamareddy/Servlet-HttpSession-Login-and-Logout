import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		RequestDispatcher rd = req.getRequestDispatcher("link.html");
		rd.include(req, res);
		
		HttpSession ses = req.getSession(false);
		if(ses!=null)
		{
			String name = (String) ses.getAttribute("name");
			out.println("Hello "+ name+" Welcome to Profile");
		}
		else
		{
			out.println("Please Login First");
			RequestDispatcher rs = req.getRequestDispatcher("login.html");
			rs.include(req, res);
		}
	}
}
