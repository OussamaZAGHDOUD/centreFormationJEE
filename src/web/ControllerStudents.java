package web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.prism.Image;

import dao.AffectationDaoImpl;
import dao.EtudiantDaoImpl;
import dao.FormationDaoImpl;
import dao.IAffectation;
import dao.IEtudiant;
import dao.IFormation;
import dao.ILogin;
import dao.ILoginEtudiant;
import dao.IReservation;
import dao.ISession;
import dao.LoginDao;
import dao.LoginDaoEtudiant;
import dao.ReservationDaoImpl;
import dao.SessionDaoImpl;
import metier.entities.Etudiant;
import metier.entities.Session;

@WebServlet("*.visiteur")
public class ControllerStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ControllerStudents() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		HttpSession session = request.getSession();
		IEtudiant ie=new EtudiantDaoImpl();
		ILoginEtudiant il=new LoginDaoEtudiant();
		ISession is=new SessionDaoImpl();
		IFormation ifo=new FormationDaoImpl();
		IAffectation iAffectation=new AffectationDaoImpl();
		IReservation iReservation=new ReservationDaoImpl();
		if(session.getAttribute("role")=="admin")
		{
			session.invalidate();
			response.sendRedirect("adminLogin.html");
		}
		
		
		else if (path.equals("/home.visiteur"))
		{
			request.getRequestDispatcher("portfolio.jsp").forward(request, response);
		}
		else if(path.equals("/reserver.visiteur"))
		{
			request.getRequestDispatcher("inscription.jsp").forward(request, response);
		}
		
		else if(path.equals("/reservermembre.visiteur"))
		{
			
			String email=(String)session.getAttribute("email");
			Etudiant e = ie.getEtudiantByEmail(email);
			request.setAttribute("idEtudiant", e.getMatricule());

			List<Session> lstsession =new ArrayList<Session>();
			for(Session s:is.tousSession())
			{
				if(s.getStatut().equals("Programmée")&&!ie.estIlAffecterAuneSessionDonnee(e.getMatricule(), s.getIdSession()))
				{	lstsession.add(s);			}		}
	
			List<Integer> listeDesSession =new ArrayList<Integer>();
			listeDesSession=iAffectation.consulterListeDesSessionsPourUnEtudiant(e.getMatricule());
			List<Session> listeS=new ArrayList<Session>();
			for(int i:listeDesSession)
			{
				listeS.add(is.getSession(i));
			}
			
			request.setAttribute("listeS", listeS);
			request.setAttribute("liste", lstsession);
				request.setAttribute("is", is);
				request.getRequestDispatcher("reserverMembre.jsp").forward(request, response);
			
		}
		
		
		else if((path.equals("/demander.visiteur"))&& request.getMethod().equals("POST"))
		{
			request.getRequestDispatcher("reserverMembre.jsp").forward(request, response);
		}
		
		
		
		else if (path.equals("/logout.visiteur"))
		{
			session.invalidate();
			request.getRequestDispatcher("portfolio.jsp").forward(request, response);
		}
	
		else if(path.equals("/validationReservation.visiteur")&& request.getMethod().equals("POST"))
		{
			String[] choix=request.getParameterValues("choix");
			List<Integer> l=new ArrayList<Integer>();
for(String i:choix)
{
	l.add(Integer.parseInt(i));
}
int idEtudiant =Integer.parseInt(request.getParameter("idEtudiant"));

for(int i:l)
{
	iReservation.save(idEtudiant, i);
}
			request.setAttribute("msg", "Votre demande de réservation a ete effectué avec succes");
response.sendRedirect("reservermembre.visiteur");			
		}
		
		
		else if (path.equals("/Sinscrire.visiteur")&& request.getMethod().equals("POST"))
		{
			String nom = request.getParameter("nom");
			Long numtel = Long.parseLong(request.getParameter("numTel"));
			String adresse = request.getParameter("adresse");
			String email=request.getParameter("email");
			String motDePasse=request.getParameter("MotDePasse");
			Etudiant e = ie.save(new Etudiant(numtel, nom, adresse,email));
			il.save(email, motDePasse, "etudiant");			
			request.setAttribute("e", e);
			session.setAttribute("nom", nom);
			session.setAttribute("email", email);
			session.setAttribute("role", "etudiant");
			
			/*
			 * List<Session> lstsession = new ArrayList<Session>(); for (Session s :
			 * is.tousSession()) { if
			 * (!s.getDateDebut().plusDays(is.getSessionNbrJour(s.getIdSession())).isBefore(
			 * LocalDate.now())) { lstsession.add(s); }
			 * 
			 * } request.setAttribute("liste", lstsession); request.setAttribute("is", is);
			 */
		//	request.getRequestDispatcher("ConfirmationInscription.jsp").forward(request, response);
		response.sendRedirect("reservermembre.visiteur");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
