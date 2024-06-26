package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
//  @WebServlet(value="/test2", loadOnStartup = 1)
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println("in init : Servlet 2"+Thread.currentThread());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy : Servlet 2"+Thread.currentThread());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in do-get : Servlet 2"+Thread.currentThread());
		//set response content type
				//Method of the HttpServletResponse : public void setContentType( String contType)
				response.setContentType("text/html");//resp pakt header
				//to send response from server ---> clnt (i.e to send resp body :) get writer instance from Http resp
				try(PrintWriter pw = response.getWriter())
				{
					pw.print("Wlecome 2 Servlets!!!!! @ "+LocalDateTime.now() ); //resp body
				}//pw.close ---WC sends PW's buffer contents to web server ----> resp pkt(SC 200 | Headers | body)
	}
}
