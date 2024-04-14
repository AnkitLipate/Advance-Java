 package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
  * Servlet implementation class TpoicsServlet
 */
@WebServlet("/topics")
public class TopicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter())
		{
			pw.print("<h5>Login Successful, from topics Servlet page....<h5>");
			//get validated user details from a cookie
			//API : Method of HttpServletRequest
			//Cookie[] getCookies() : null => no Cookies
			//not null ----cookies exist -- iterate over the array --look for the cookie holding the user details 
			//send it's value in the resp.
			Cookie[] cookies =  request.getCookies();
			if(cookies !=null)
			{
				for(Cookie c : cookies)
					if(c.getName().equals("validate_user_dtls")) {
						pw.print("<h5>User Details fetched from a Cookie"+c.getValue()+"</h5>");
						break; 
					}
			}
			else//no cookies
				pw.print("<h5>No Cookie : session tracking failed!!!!!!</h5>");
		}
	}

}
