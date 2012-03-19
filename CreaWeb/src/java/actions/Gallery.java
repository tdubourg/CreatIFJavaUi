/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Oeuvre;
import service.Service;

/**
 *
 * @author
 * troll
 */
public class Gallery extends Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		SimpleDateFormat df;
		String startDate = req.getParameter("start_date");
		String endDate = req.getParameter("end_date");
		Date startDated = null, endDated = null;
		try {
			List<Oeuvre> oeuvreList;
			oeuvreList = Service.rechercherToutesLesPeintures();
			oeuvreList.addAll(Service.rechercherToutesLesSculptures());
			System.out.println("List initialized.");
			if (endDate != null && startDate != null) {
				System.out.println("Dates are not null");
				try {
					df = new SimpleDateFormat("dd-MM-yy");
					df.setLenient(false);
					startDated = df.parse(startDate);
					endDated = df.parse(endDate);
				} catch(Exception e) {
					System.out.println("Format invalide.");
					startDate = null;
					endDate = null;
				}

				System.out.println("Dates demandées :\nStart=" + startDated + "\nEnd=" + endDated);
			} else {
				System.out.println("Aucune date demandée.");
			}

			for (Oeuvre o : oeuvreList) {
				if (endDate != null && startDate != null && !Service.oeuvreDisponible(o, startDated, endDated)) {
					oeuvreList.remove(o);
				}
			}
			System.out.println(oeuvreList);
			req.getSession(true).setAttribute("oeuvreList", oeuvreList);
		} catch (Exception e) {
			System.out.println("Erreur inconnue.");
		}
		return "galleries_center_col.jsp";
	}
}