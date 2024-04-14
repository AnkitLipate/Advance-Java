package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojos.User;
import utils.DBUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/validate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
	
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		try{
			//dao inst
			userDao = new UserDaoImpl(); 
		}catch (Exception e) {
			//to inform the WC that init() has failed --so don't continue with the 
			//servicing : throw ServletExc
			//centralized exc handling in servlets
			throw new ServletException("err in init of"+getClass().getName(),e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {	 
		try {
			userDao.cleanUp();
			DBUtils.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("err in destroy of"+getClass().getName()+""+e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1 : set cont type
		response.setContentType("text/html");
		//pw
		try(PrintWriter pw = response.getWriter()) {
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			//Invoke dao's method : for user validation
			User user = userDao.validateUser(email, password);
			//chk for valid or invalid login
			if(user == null)
			{
				//invalid --retry link ---> login form
				pw.print("<h5>Invalid Login, please <a href='login.html'>Retry</a></h5>");
			} 
			else {
				//send in the resp : validate user details 
				pw.print("<h5>Login Successful from login servlet....</h5>");//does not appear on the clnt browser
//				pw.flush(); Un comment  this to understand : IllegalStateException : Can not call sendRedirect,
				//after comminting the resp(pw.flush())
				//create a cookie : using validated user details
				//javax.servlet.http.Cookie(String cookieName, String cookieValue)
				Cookie c1 = new Cookie("valoidated_user_dtls", user.toString());//cookie instance created in servlet
																							//heap
				//send the cookie to the clnt (in response header)
				//Method of HttpServletResponse 
				//public void addCookie(Cookie c)
				response.addCookie(c1);

				
				//in case of successful login : redirect the clnt to the topics page
				//API : HttpServletResponse
				//public void sendRedirect(String Location) throws IOException
				response.sendRedirect("topics"); //prog
				//WC : sends temp redirect resp to the clnt
				//sts code : SC302 | location=topics , content-length=0 | body : EMPY
				//clnt browser : generate a NEW request	
				//URL : http://host:port/day4.1/topics, method=GET
				//request header : cookie : validated_user_dtls : toString of user	
			}
			
		}catch (Exception e) {
			throw new ServletException("err in do-post of"+getClass().getName(),e);
		}
	}

}
