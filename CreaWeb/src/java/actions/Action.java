package actions;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author
 * troll
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.Service;
public abstract class Action {
	protected Service service;
	
	public void setService(Service s) {
		service = s;
	}
	
	public abstract String execute(HttpServletRequest req, HttpServletResponse resp);
}
