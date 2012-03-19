package controllers;

/*
 * To
 * change
 * this
 * template,
 * choose
 * Tools
 * |
 * Templates
 * and
 * open
 * the
 * template
 * in
 * the
 * editor.
 */
import actions.Action;
import actions.Index;
import actions.Login;
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
@WebServlet(name = "Controller", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("On est passé par ici.");
		String actionStr = req.getParameter("action");
		Action action = getAction(actionStr);
		if (action != null) {
			String view = action.execute(req, resp);
			System.out.println("Ici");
			RequestDispatcher rd = req.getRequestDispatcher(view);
			System.out.println("Là");
			try {
				rd.forward(req, resp);
			} catch (ServletException ex) {
				Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IOException ex) {
				Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else {
			System.out.println("action == null");
		}
	}

	private Action getAction(String actionStr) {
		Action action = null;
		if ("submit_gallery".equals(actionStr)) {
			System.out.println("Submitting the gallery !");
			action = new actions.Checkout();
		} else if("help".equals(actionStr)) {
			action = new actions.Help();
		}
		
		else if("login".equals(actionStr)) {
			action = new actions.Login();
		} else if("load_catalog".equals(actionStr)) {
			action = new actions.Gallery();
		} else {
			System.out.println("Request received for index page");
			action = new Index();
		}
		return action;
	}
}