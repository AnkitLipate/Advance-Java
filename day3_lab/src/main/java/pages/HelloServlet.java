package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//http:host:port/day3_lab/hello : URL
// URI :/day3_lab/hello
//URL Pattern : /hello
//WC creates empty Map @ web app dep time.
//populates it. Key : /hello
//Value : pages.HelloServlet
@WebServlet(value={"/hello","/hi"}) 
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println("in init : by"+Thread.currentThread());//name:prio:thrdgrp
	}
 
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy : by "+Thread.currentThread());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in do-get : by "+Thread.currentThread());
		//1.set Content type : resp header
		response.setContentType("/text/html");
		//2.get char buffered o/p strm : to send the resp from servlet ---> clnt
		try(PrintWriter pw = response.getWriter())
		{
			//resp body
			pw.print("<h5>Hello from Servlet, Server TimeStamp"+LocalDateTime.now()+"</h5>");
		}
	}

}
