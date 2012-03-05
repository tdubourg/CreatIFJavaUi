/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import actions.Action;
import actions.Index;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Service;

/**
 *
 * @author
 * troll
 */
@WebServlet(name = "Controller", urlPatterns = {"/WEB-INF/"})
public class Controller extends HttpServlet { 
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("On est passé par ici.");
		String actionStr = req.getParameter("action");
		Action action = getAction(actionStr);
		if (action != null) {
			String view = action.execute(req, resp);
			RequestDispatcher rd = req.getRequestDispatcher(view);
			try {
				rd.forward(req, resp);
			} catch (ServletException ex) {
				Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IOException ex) {
				Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws IOException, ServletException {

		PrintWriter out = resp.getWriter();
		
		out.println("Hi folks!");
	}

	private Action getAction(String actionStr) {
		Action action = null;
		if ("index".equals(actionStr)) {
			System.out.println("Request received for index page");
			action = new Index();
		} else if("galleries".equals(actionStr)) {
			action = new controllers.Galleries();
		}
		return action;
	}
}