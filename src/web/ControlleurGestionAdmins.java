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

import dao.ILoginAdmin;
import dao.LoginDaoAdmin;
import metier.entities.Admin;
import metier.entities.Etudiant;

/**
 * Servlet implementation class ControlleurGestionAdmins
 */
@WebServlet("*.GestionAdmins")
public class ControlleurGestionAdmins extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ILoginAdmin iLoginAdmin=new LoginDaoAdmin();
    public ControlleurGestionAdmins() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		if(!session.getAttribute("role").equals("admin"))
		{
			session.invalidate();
			response.sendError(500);
		}

		else if(path.equals("/consulter.GestionAdmins"))
		{
			/*
			 *                 En cours
			 * if(request.getParameter("email")!=null) { List<Admin> lst=new
			 * ArrayList<Admin>();
			 * lst=iLoginAdmin.chercherAdminParEmail(request.getParameter("email"));
			 * request.setAttribute("liste", lst); }
			 */
			List<Admin> lst=new ArrayList<Admin>();
			lst=iLoginAdmin.toutAdmins();
			request.setAttribute("liste", lst);
			
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}
		else if(path.equals("/ajouter.GestionAdmins"))
		{
			Admin a=new Admin();
			request.setAttribute("a", a);
			request.getRequestDispatcher("ajouterAdmin.jsp").forward(request, response);
		}
		else if (path.equals("/ConfirmationAjoutAdmin.GestionAdmins") && request.getMethod().equals("POST")  )
		{
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String role = request.getParameter("role");

			Admin a=new Admin(email, role, password);
					iLoginAdmin.save(email, role, password);
			request.setAttribute("a", a);

			request.getRequestDispatcher("ConfirmationAjoutAdmin.jsp").forward(request, response);
			
			
		}
		else if(path.equals("/SupprimerAdmin.GestionAdmins"))	{
			
			iLoginAdmin.deleteFromLoginTable(request.getParameter("email"));
				response.sendRedirect("consulter.GestionAdmins");			
		}
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
