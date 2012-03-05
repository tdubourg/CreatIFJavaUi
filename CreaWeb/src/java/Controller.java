/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import actions.Action;
import actions.Index;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Controller", urlPatterns = {"/"})
public class Controller extends HttpServlet { 
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		String actionStr = req.getParameter("action");
		Action action = getAction(actionStr);
		if (action != null) {
		}
	}

	private Action getAction(String actionStr) {
		Action action = null;
		if ("index".equals(actionStr)) {
			action = new Index();
		} else if("galleries".equals(actionStr)) {
			action = new actions.Galleries();
		}
		return action;
	}
}