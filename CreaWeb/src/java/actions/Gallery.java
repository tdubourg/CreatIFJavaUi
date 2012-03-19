/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
			List<Oeuvre> oeuvreList2 = new ArrayList<Oeuvre>();
			System.out.println("List initialized.");
			if (endDate != null && startDate != null) {
				System.out.println("Dates are not null");
				try {
					df = new SimpleDateFormat("dd/MM/yyyy");
					df.setLenient(false);
					startDated = df.parse(startDate);
					endDated = df.parse(endDate);
				} catch (Exception e) {
					System.out.println("Format invalide.");
					startDate = null;
					endDate = null;
				}

				System.out.println("Dates demandées :\nStart=" + startDated + "\nEnd=" + endDated);
			} else {
				
				System.out.println("Aucune date demandée.");
			}
			if(startDate == null || endDate == null) {
				oeuvreList2.addAll(oeuvreList);
			}

			try {
				for (Oeuvre o : oeuvreList) {
					try {
						if (endDate != null && startDate != null && Service.oeuvreDisponible(o, startDated, endDated)) {
							oeuvreList2.add(o);
						} else {
							try {
								System.out.println("L'oeuvre " + o.getNom() + " n'est pas disponible pour les dates " + startDated + "-" + endDated);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(oeuvreList);
			try {
				req.getSession(true).setAttribute("oeuvreList", oeuvreList2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("Erreur inconnue.");
		}
		return "galleries_center_col.jsp";
	}
}