package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AffectationDaoImpl;
import dao.EtudiantDaoImpl;
import dao.FormationDaoImpl;
import dao.IAffectation;
import dao.IEtudiant;
import dao.IFormation;
import dao.ILoginEtudiant;
import dao.IReservation;
import dao.ISession;
import dao.LoginDaoEtudiant;
import dao.ReservationDaoImpl;
import dao.SessionDaoImpl;
import metier.entities.Etudiant;
import metier.entities.Formation;
import metier.entities.GenererFichier;
import metier.entities.SendEmail;
import metier.entities.Session;
import javax.mail.*;


@WebServlet("*.do")
public class Controller extends HttpServlet {
	private IEtudiant etudiantMetier;
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		etudiantMetier = new EtudiantDaoImpl();
	}

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String path = request.getServletPath();

		EtudiantModel emodel = new EtudiantModel();
		IEtudiant ie = new EtudiantDaoImpl();
		List<Etudiant> ls = new ArrayList<Etudiant>();

		SessionModel mmodel = new SessionModel();
		ISession im = new SessionDaoImpl();
		List<Session> lst = new ArrayList<Session>();

		FormationModel fmodel = new FormationModel();
		IFormation ifo = new FormationDaoImpl();
		List<Formation> lstf = new ArrayList<Formation>();

		IAffectation ia = new AffectationDaoImpl();
		ILoginEtudiant ilog = new LoginDaoEtudiant();

		IReservation iReservation = new ReservationDaoImpl();

		/*
		 * if (path.equals("/home.do")) {
		 * 
		 * 
		 * request.getRequestDispatcher("adminLogin.html").forward(request, response);
		 * 
		 * } else
		 */
		if(session.getAttribute("role")==(null))
		{
			response.sendRedirect("adminLogin.html");

		}
		else if (!session.getAttribute("role").equals("admin") && !session.getAttribute("role").equals("assistant")) {
			session.invalidate();
			response.sendRedirect("adminLogin.html");

		}

		else {

			if (path.equals("/home.do")) {
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}

			else if (path.equals("/etudiant.do")) {

				String n = (String) request.getParameter("nomEt");
				if (n == null) {
					ls = ie.toutEtudiants();
					emodel.setEtudiants(ls);
					request.setAttribute("liste", emodel);
				} else {
					ls = ie.chercherEtudiantParNom("%" + n + "%");
					emodel.setEtudiants(ls);
					request.setAttribute("liste", emodel);

				}
				request.getRequestDispatcher("etudiant.jsp").forward(request, response);
			} else if (path.equals("/Supprimer.do")) {

				int i = Integer.parseInt(request.getParameter("id"));

				if (ie.estIlAffecter(i)) {
					String nomEt = ie.getEtudiant(i).getNom();

					request.setAttribute("msg", "l'étudiant " + nomEt
							+ " est affecté a une formation !\n Vous ne pouvez pas le supprimer !");
					request.getRequestDispatcher("etudiant.jsp").forward(request, response);
				} else {
					try {
						if(ilog.estIlInscritParSite(ie.getEtudiant(i).getEmail()))
						ilog.deleteFromLoginTable(ie.getEtudiant(i).getEmail());
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ie.deleteEtudiant(i);

					response.sendRedirect("etudiant.do?nomEt=");
				}

			} else if (path.equals("/ajouter.do"))

			{
				request.setAttribute("e", new Etudiant());

				request.getRequestDispatcher("SaisieEtudiant.jsp").forward(request, response);
			} else if (path.equals("/ConfirmationAjout.do") && request.getMethod().equals("POST"))

			{
				String nom = request.getParameter("nom");
				Long numtel = Long.parseLong(request.getParameter("numTel"));
				String adresse = request.getParameter("adresse");
				String email = request.getParameter("email");

				Etudiant e = ie.save(new Etudiant(numtel, nom, adresse, email));

				request.setAttribute("e", e);

				request.getRequestDispatcher("ConfirmationAjout.jsp").forward(request, response);

			}

			else if (path.equals("/Edit.do")) {
				int id = Integer.parseInt(request.getParameter("id"));
				Etudiant e = ie.getEtudiant(id);
				request.setAttribute("e", e);
				request.getRequestDispatcher("EditEtudiant.jsp").forward(request, response);

			}

			else if (path.equals("/MiseAjourEtudiant.do") && request.getMethod().equals("POST")) {
				int mat = Integer.parseInt(request.getParameter("matricule"));
				String nom = request.getParameter("nom");
				Long tel = Long.parseLong(request.getParameter("numTel"));
				String adresse = request.getParameter("adresse");
				Etudiant e = ie.getEtudiant(mat);

				e.setAdresse(adresse);
				e.setNom(nom);
				e.setNumTel(tel);

				ie.update(e);

				request.setAttribute("e", e);
				request.getRequestDispatcher("ConfirmationAjout.jsp").forward(request, response);
			} else if (path.equals("/session.do")) {
				String n = (String) request.getParameter("nomFormation");
				if(im.tousSession()!=null) {
				List<Integer> listeEncours = im.SessionEnCours();
				List<Integer> listeTerminer = im.SessionTerminee();
				for (Session s : im.tousSession()) {
					im.update(s, "Programmée");
					s.setStatut("Programmée");
					for (int i = 0; i < listeTerminer.size(); i++) {
						if (s.getIdSession() == listeTerminer.get(i)) {
							im.update(s, "Terminée");
							s.setStatut("Terminée");
						}
					}
					
					for (int i = 0; i < listeEncours.size(); i++) {
						if (s.getIdSession() == listeEncours.get(i)) {
							im.update(s, "En cours");
							s.setStatut("En cours");
						}
					}
					
				
					
					
}}				
				if (n == null) {
					lst = im.tousSession();
					mmodel.setSessions(lst);

				} else {
					lstf = ifo.chercherFormationParNom("%" + n + "%");
					List<Integer> l = new ArrayList<Integer>();

					for (Formation f : lstf) {
						l.add(f.getIdFormation());
					}
					for (Integer i : l) {
						lst.addAll(im.chercherSessionParIdFormation(i));
					}

					mmodel.setSessions(lst);
				}

				List<Session> ll = new ArrayList<Session>();
				ll = mmodel.getSessions();		
				request.setAttribute("im", im);
				request.setAttribute("liste", ll);
				request.getRequestDispatcher("session.jsp").forward(request, response);
			}

			else if (path.equals("/ajouterSession.do"))

			{
				request.setAttribute("m", new Session());
				request.setAttribute("fmodel", fmodel);
				request.setAttribute("im", im);

				fmodel.setFormations(ifo.tousFormation());
				request.getRequestDispatcher("SaisieSession.jsp").forward(request, response);
			}

			else if (path.equals("/ConfirmationAjoutSession.do") && request.getMethod().equals("POST"))

			{
				// ifo.getFormationByNom((request.getParameter("nomFormation"))).getIdFormation();
				int idFormation = Integer.parseInt(request.getParameter("idFormation"));
				String nomEns = request.getParameter("nomEns");
				String dated = request.getParameter("dateD");
				Integer nbrseance = Integer.parseInt(request.getParameter("nbrseance"));

				Session m = new Session(idFormation, nomEns, dated, nbrseance);

				im.save(m);

				String nomformation = ifo.getFormation(idFormation).getNomFormation();
				request.setAttribute("nomFormation", nomformation);
				request.setAttribute("m", m);
				request.setAttribute("im", im);
				request.getRequestDispatcher("ConfirmationAjoutSession.jsp").forward(request, response);

			}

			else if (path.equals("/SupprimerSession.do")) {
				int id = Integer.parseInt(request.getParameter("id"));

				if (im.contientElleDesEtudiants(id)) {
					request.setAttribute("msg",
							"Il y a plus q'un étudiant inscrit dans cette session ! Vous ne pouvez pas le supprimer !");
					request.getRequestDispatcher("session.jsp").forward(request, response);
				} else {
					im.deleteSession(id);
					response.sendRedirect("session.do?nomFormation=");
				}
			}

			else if (path.equals("/EditSession.do"))

			{
				int id = Integer.parseInt(request.getParameter("id"));
				Session m = im.getSession(id);

				request.setAttribute("m", m);
				request.setAttribute("im", im);
				request.setAttribute("id", id);
				request.getRequestDispatcher("EditSession.jsp").forward(request, response);

			} else if (path.equals("/ConfirmationModificationSession.do") && request.getMethod().equals("POST")) {
				Session m = im.getSession(Integer.parseInt(request.getParameter("idSession")));
				
				int formationId = Integer.parseInt(request.getParameter("idFormation"));
				String nomEns = request.getParameter("nomEns");
				String dated = request.getParameter("dateD");
				int nbrseance = Integer.parseInt(request.getParameter("nbrseance"));
			
				
				
				int id = m.getIdSession();
				m.setNomEnseignant(nomEns);
				m.setNmbrSeanceParJour(nbrseance);
				m.setDateDebut(dated);
				
				for(int i:ia.consulter(m.getIdSession()))
				{
					new SendEmail().envoyerEmail( ie.getEtudiant(i).getEmail(), "Modification d'une session de formation ",
							"Bonjour, \n\n"
							+ "La formation  : "+im.getSessionNom(m.getIdSession())+" a été changée ,"
									+ " \nles nouvelles informations sont :"
								+"\n"	+m+
									
							"\n\n Cordialement  Centre BenMahmoud De Formation "
							+ "\nCité Tarek Ebn Zied \"El Fadden\", 2022 Kalaat-El-Andaleus, Aryanah"
							);
				}
				im.update(m);
				request.setAttribute("im", im);
				request.setAttribute("m", m);
				request.getRequestDispatcher("ConfirmationAjoutSession.jsp").forward(request, response);
			}

			/*
			 * else if (path.equals("/Affecter.do")) { Integer idFormation = 0;
			 * 
			 * if (request.getParameter("choixFormation") != null) { try { idFormation =
			 * Integer.parseInt(request.getParameter("choixFormation"));
			 * 
			 * } catch (Exception e) { idFormation =
			 * ifo.getFormationByNom(request.getParameter("choixFormation")).getIdFormation(
			 * ); }
			 * 
			 * String n = ifo.getFormation(idFormation).getNomFormation();
			 * request.setAttribute("nomFor", n); request.setAttribute("idFormation",
			 * idFormation); for (Session s : im.tousSession()) { if (s.getFormationId() ==
			 * idFormation) { lst.add(s); System.out.println(s.getFormationId() + "   " +
			 * s.getNomEnseignant()); } //
			 * im.tousSession().removeIf(s->s.getFormationId()!=idFormation); }
			 * 
			 * } if (request.getParameter("choixSession") != null) {
			 * request.setAttribute("idFormation", idFormation);
			 * 
			 * int idSession = Integer.parseInt(request.getParameter("choixSession"));
			 * Session s = im.getSession(idSession); int id =
			 * Integer.parseInt(request.getParameter("idEtudiant")); Etudiant e =
			 * ie.getEtudiant(id); ia.save(e, s);
			 * 
			 * request.getRequestDispatcher("session.jsp"); } mmodel.setListe(lst);
			 * 
			 * request.setAttribute("idFormation", idFormation); int id =
			 * Integer.parseInt(request.getParameter("idEtudiant")); Etudiant e =
			 * ie.getEtudiant(id); request.setAttribute("e", e); request.setAttribute("ifo",
			 * ifo); request.setAttribute("im", im); request.setAttribute("mmodel", mmodel);
			 * request.getRequestDispatcher("affecter.jsp").forward(request, response); }
			 */

			else if (path.equals("/Affecter.do")) {
				Integer idFormation = 0;
				int idEtudiant = Integer.parseInt(request.getParameter("idEtudiant"));
				if (request.getParameter("choixFormation") != null) {
					idFormation = Integer.parseInt(request.getParameter("choixFormation"));

					/*
					 * try { idFormation = Integer.parseInt(request.getParameter("choixFormation"));
					 * 
					 * } catch (Exception e) { idFormation =
					 * ifo.getFormationByNom(request.getParameter("choixFormation")).getIdFormation(
					 * ); }
					 */
					String n = ifo.getFormation(idFormation).getNomFormation();
					request.setAttribute("nomFor", n);
					request.setAttribute("idFormation", idFormation);
					/*
					 * for (Session s : im.tousSession()) { if (s.getFormationId() == idFormation) {
					 * lst.add(s); } //
					 * im.tousSession().removeIf(s->s.getFormationId()!=idFormation); }
					 */

					for (Session s : im.tousSession()) {
						if ((s.getFormationId() == idFormation) && s.getStatut().equals("Programmée")
								&& !ie.estIlAffecterAuneSessionDonnee(idEtudiant, s.getIdSession())) {
							lst.add(s);
						}
						// im.tousSession().removeIf(s->s.getFormationId()!=idFormation);
					}
				}
				if (request.getParameter("choixSession") != null) {
					request.setAttribute("idFormation", idFormation);

					int idSession = Integer.parseInt(request.getParameter("choixSession"));
					Session s = im.getSession(idSession);
					int id = Integer.parseInt(request.getParameter("idEtudiant"));
					Etudiant e = ie.getEtudiant(id);
					ia.save(e, s);
					new SendEmail().envoyerEmail(e.getEmail(), "Affectation à une session",
							"Bonjour,\n\n Vous etes affecté a la formation : "+im.getSessionNom(s.getIdSession())+"\n"+s+
							"\n\n Cordialement\nCentre BenMahmoud De Formation "
							+ "\nCité Tarek Ebn Zied \"El Fadden\", 2022 Kalaat-El-Andaleus, Aryanah"
							);

					request.getRequestDispatcher("session.jsp");
				}
				mmodel.setListe(lst);

				request.setAttribute("idFormation", idFormation);
				int id = Integer.parseInt(request.getParameter("idEtudiant"));
				Etudiant e = ie.getEtudiant(id);
				request.setAttribute("e", e);
				request.setAttribute("ifo", ifo);
				request.setAttribute("im", im);
				request.setAttribute("mmodel", mmodel);
				request.getRequestDispatcher("affecter.jsp").forward(request, response);
			}

			else if (path.equals("/ConsulterListeEtudiants.do")) {
				int id = Integer.parseInt(request.getParameter("id"));
				Session m = im.getSession(id);
				int nbr = m.getNmbrSeanceParJour();
				List<Integer> l = ia.consulter(id);
				for (Integer i : l) {
					Etudiant e = ie.getEtudiant(i);
					ls.add(e);
				}
				ls.removeIf(a -> a == null);
				String nom = im.getSessionNom(id);
				int nbrjour = im.getSessionNbrJour(id);
				String nomEns = im.getSession(id).getNomEnseignant();
				request.setAttribute("statut", m.getStatut());
				request.setAttribute("nomEns", nomEns);
				request.setAttribute("nomSession", nom);
				request.setAttribute("liste", ls);
				request.setAttribute("id", id);
				request.getRequestDispatcher("consulterSession.jsp").forward(request, response);
			} else if (path.equals("/genererFeuille.do")) {
				int id = Integer.parseInt(request.getParameter("id"));
				Session m = im.getSession(id);
				int nbr = m.getNmbrSeanceParJour();
				List<Integer> l = ia.consulter(id);
				for (Integer i : l) {
					Etudiant e = ie.getEtudiant(i);
					ls.add(e);
				}
				ls.removeIf(a -> a == null);
				String nom = im.getSessionNom(id);

				GenererFichier g = new GenererFichier(ls, nbr, nom);
				request.setAttribute("nomSession", nom);
				request.setAttribute("liste", ls);
				request.setAttribute("id", id);
				request.getRequestDispatcher("consulterSession.jsp").forward(request, response);
			} else if (path.equals("/formation.do")) {
				String n = (String) request.getParameter("nomFormation");
				if (n == null) {
					lstf = ifo.tousFormation();
					fmodel.setFormations(lstf);
					request.setAttribute("liste", fmodel);
				} else {
					lstf = ifo.chercherFormationParNom("%" + n + "%");
					fmodel.setFormations(lstf);
					request.setAttribute("liste", fmodel);
				}
				request.getRequestDispatcher("formation.jsp").forward(request, response);
			} else if (path.equals("/ajouterFormation.do")) {
				request.setAttribute("f", new Formation());
				request.getRequestDispatcher("SaisieFormation.jsp").forward(request, response);
			}

			else if (path.equals("/ConfirmationAjoutFormation.do") && request.getMethod().equals("POST")) {
				String nom = request.getParameter("nomFormation");
				String dated = request.getParameter("dateD");
				Integer nbrJour = Integer.parseInt(request.getParameter("nbrJour"));

				Formation f = new Formation(nom, nbrJour);
				ifo.save(f);
				request.setAttribute("f", f);
				request.getRequestDispatcher("ConfirmationAjoutFormation.jsp").forward(request, response);
			} else if (path.equals("/SupprimerFormation.do")) {

				int id = Integer.parseInt(request.getParameter("id"));

				if (ifo.contientElleDesSession(id)) {
					String nom = ifo.getFormation(id).getNomFormation();
					request.setAttribute("msg",
							"La formation " + nom + " contient des sessions ! Vous ne pouvez pas le supprimer !");
					request.getRequestDispatcher("formation.jsp").forward(request, response);
				} else {

					ifo.deleteFormation(id);
					response.sendRedirect("formation.do?nomFormation=");
				}

			}

			else if (path.equals("/EditFormation.do"))

			{
				int id = Integer.parseInt(request.getParameter("id"));
				Formation f = ifo.getFormation(id);

				request.setAttribute("f", f);
				request.setAttribute("ifo", ifo);
				request.setAttribute("id", id);
				request.getRequestDispatcher("EditFormation.jsp").forward(request, response);
			} else if (path.equals("/ConfirmationModificationFormation.do") && request.getMethod().equals("POST")) {
				Formation f = ifo.getFormation(Integer.parseInt(request.getParameter("idFormation")));

				f.setNbrJour(Integer.parseInt(request.getParameter("nbrJour")));
				f.setNomFormation(request.getParameter("nomFormation"));
				ifo.update(f);
				request.setAttribute("ifo", ifo);
				request.setAttribute("f", f);
				request.getRequestDispatcher("ConfirmationAjoutFormation.jsp").forward(request, response);
			} else if (path.equals("/logout.do")) {
				session.invalidate();
				response.sendRedirect("home.login");
			}

			else if (path.equals("/AffecterDeSite.do")) {

				int idEtudiant = Integer.parseInt(request.getParameter("idEtudiant"));
				Etudiant e = ie.save(ie.getEtudiant(idEtudiant));
				request.setAttribute("e", e);
				request.setAttribute("idEtudiant", e.getMatricule());
				request.getRequestDispatcher("affecterParSite.jsp").forward(request, response);

				Integer idFormation = 0;

				if (request.getParameter("choixFormation") != null) {
					try {
						idFormation = Integer.parseInt(request.getParameter("choixFormation"));

					} catch (Exception e1) {
						idFormation = ifo.getFormationByNom(request.getParameter("choixFormation")).getIdFormation();
					}

					String n = ifo.getFormation(idFormation).getNomFormation();
					request.setAttribute("nomFor", n);
					request.setAttribute("idFormation", idFormation);
					for (Session s : im.tousSession()) {
						if (s.getFormationId() == idFormation) {
							lst.add(s);
						}
						// im.tousSession().removeIf(s->s.getFormationId()!=idFormation);
					}

				}
				if (request.getParameter("choixSession") != null) {
					request.setAttribute("idFormation", idFormation);

					int idSession = Integer.parseInt(request.getParameter("choixSession"));
					Session s = im.getSession(idSession);
					int id = Integer.parseInt(request.getParameter("idEtudiant"));
					Etudiant e1 = ie.getEtudiant(id);
					ia.save(e1, s);
					new SendEmail().envoyerEmail(e1.getEmail(), "Affectation à une session",
							"Bonjour,\n\n Vous etes affecté a la formation : "+im.getSessionNom(s.getIdSession())+"\n"+s+
							"\n\n Cordialement\nCentre BenMahmoud De Formation "
							+ "\nCité Tarek Ebn Zied \"El Fadden\", 2022 Kalaat-El-Andaleus, Aryanah"
							);


					request.getRequestDispatcher("session.jsp");
				}
				mmodel.setListe(lst);

				request.setAttribute("idFormation", idFormation);
				int id = Integer.parseInt(request.getParameter("idEtudiant"));
				Etudiant e1 = ie.getEtudiant(id);
				request.setAttribute("e", e1);
				request.setAttribute("ifo", ifo);
				request.setAttribute("im", im);
				request.setAttribute("mmodel", mmodel);

			} else if (path.equals("/AffecterDesEtudiantsParGroup.do")) {
				List<Etudiant> liste = new ArrayList<Etudiant>();
				int idSession = Integer.parseInt(request.getParameter("id"));
				List<Integer> l = ie.getEtudiantsNonAffecterASessionDonnee(idSession);
				for (Integer i : l) {
					Etudiant e = ie.getEtudiant(i);
					liste.add(e);

				}

				request.setAttribute("choixFormation", im.getSession(idSession).getFormationId());
				request.setAttribute("idSession", idSession);

				request.setAttribute("liste", liste);
				request.getRequestDispatcher("AffecterUnGroupEtudiant.jsp").forward(request, response);
			}

			else if (path.equals("/reservation.do")) {

				request.setAttribute("liste", iReservation.consulterToutesLesReservation());
				request.setAttribute("ifo", ifo);
				request.setAttribute("ie", ie);
				request.setAttribute("im", im);

				// iReservation.consulterToutesLesReservation().forEach((a,b)->System.out.println(a
				// +" "+b));
				request.getRequestDispatcher("reservation.jsp").forward(request, response);

			} else if (path.equals("/AffecterE.do")) {
				int idEtudiant = Integer.parseInt(request.getParameter("idEtudiant"));
				int idSession = Integer.parseInt(request.getParameter("idSession"));

				ia.save(ie.getEtudiant(idEtudiant), im.getSession(idSession));
				new SendEmail().envoyerEmail(ie.getEtudiant(idEtudiant).getEmail(), "Affectation à une session",
						"Bonjour,\n\n Vous etes affecté a la formation : "+im.getSessionNom(idSession)+"\n"+im.getSession(idSession)+
						"\n\n Cordialement\nCentre BenMahmoud De Formation "
						+ "\nCité Tarek Ebn Zied \"El Fadden\", 2022 Kalaat-El-Andaleus, Aryanah"
						);


				iReservation.deleteReservation(idEtudiant, idSession);

				response.sendRedirect("reservation.do");
			}

			else {
				request.getRequestDispatcher("home.login").forward(request, response);
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
