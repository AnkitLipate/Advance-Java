package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class HelloWorldServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in do-get : invoked by "+Thread.currentThread());
		//set response content type
		//Method of the HttpServletResponse : public void setContentType( String contType)
		resp.setContentType("text/html");//resp pakt header
		//to send response from server ---> clnt (i.e to send resp body :) get writer instance from Http resp
		try(PrintWriter pw = resp.getWriter())
		{
			pw.print("Wlecome 2 Servlets!!!!! @ "+LocalDateTime.now() ); //resp body
		}//pw.close ---WC sends PW's buffer contents to web server ----> resp pkt(SC 200 | Headers | body)
	}

	@Override
	public void destroy() {
		System.out.println("in destroy : invoked by "+Thread.currentThread());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init : invoked by "+Thread.currentThread());
	}

}
