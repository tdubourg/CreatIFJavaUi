/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import controllers.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Client;
import service.Service;
import util.JpaUtil;

/**
 *
 * @author
 * troll
 */
public class Login extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		//req.setAttribute("login", "Hi World!");
		System.out.println("AVANT");
		
		System.out.println("Passé par Login()");
		
		int numClient = 0;
		if(req.getParameter("numClient") == null) {
			System.out.println("Aucune demande d'identification effectuée.");
			return "login.jsp";
		}
		try {
			numClient = Integer.parseInt((String)req.getParameter("numClient"));
		} catch(Exception e) {
			numClient = 0;
			Logger.getLogger(Controller.class.getName()).log(Level.INFO, "numClient was not a valid integer : " + req.getAttribute("numClient"));
		}
		Client c = new Client();
		c.setNumClient(numClient);
		boolean loginSucessful = Service.clientExistant(c);
		
		System.out.println((loginSucessful) ? "Login sucessful !" : "Login unsuccessful !");
		
		return (!loginSucessful) ? "login.jsp?msg=err" : "galleries.jsp";
	}
	
}
