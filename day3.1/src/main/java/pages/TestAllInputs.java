package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestAllInputs
 */
@WebServlet("/test_input")
public class TestAllInputs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set response content type : Header
		response.setContentType("text/html");
		// open PW : to send resp from servlet ----> clnt
		try(PrintWriter pw = response.getWriter())
		{
			//read request parameters n send resp 
			pw.print("<h4> Hello, "+request.getParameter("f1")+"<h4>");
			pw.print("<h4> Favorite Colors "+Arrays.toString(request.getParameterValues("clr")) +"<h4>");
			pw.print("<h4> Selected Browser "+request.getParameter("browser")+"<h4>");
			pw.print("<h4> Selected City "+request.getParameter("myselect")+"<h4>");
			pw.print("<h4> About: "+request.getParameter("info")+"<h4>");
		}
	}

}
