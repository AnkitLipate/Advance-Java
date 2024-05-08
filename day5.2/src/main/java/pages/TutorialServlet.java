package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TutorialDaoImpl;

/**
 * Servlet implementation class TutorialServlet
 */
@WebServlet("/tutorials")
public class TutorialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// get session
			HttpSession session = request.getSession();
			// get tut dao instance from the session
			TutorialDaoImpl tutDao = (TutorialDaoImpl) session.getAttribute("tut_dao");
			if (tutDao != null) {
				
				// invoke tut dao's method to fetch all tut names from a choosen topic
				String topicName = request.getParameter("topic");
				pw.print("<h4>All tutorials  Under topic :" + topicName + "</h4>");
				allTutorialsByTopic.forEach(tutName -> pw
						.print("<a href='tutorial_details?name=" + tutName + "'>" + tutName + "</a></br>"));
			}else {
				//no cookies : no session tracking !
				pw.print("<h5>No cookies : session tracking failed !!!!!</h5>");
			}
			} catch (Exception e) {
				throw new ServletException("err in do-get of "+getClass().getName(),e);
			

		}
	}

}
