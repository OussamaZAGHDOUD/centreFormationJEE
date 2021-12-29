package web;


	import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EtudiantDaoImpl;
import dao.IEtudiant;
import dao.LoginDaoEtudiant;
import metier.entities.LoginEntity;



	@WebServlet("/login.etudiant")
	public class LoginEtudiantControlleur  extends HttpServlet {
	    private LoginDaoEtudiant loginDao;
	    public void init() {
	        loginDao = new LoginDaoEtudiant();
	    }

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	// TODO Auto-generated method stub
			HttpSession session=request.getSession();
			
			
				if (session.getAttribute("role")=="etudiant")
			request.getRequestDispatcher("portfolio.jsp").forward(request, response);
			else if(session.getAttribute("role")=="admin")
			{
				session.invalidate();

				request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("loginEtudiant.jsp").forward(request, response);
			}
	    
	    }
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	    	IEtudiant ie=new EtudiantDaoImpl();
            HttpSession session = request.getSession();


	        String email = request.getParameter("email");
	        String password = request.getParameter("MotDePasse");
	        LoginEntity loginEntity = new LoginEntity();
	        loginEntity.setEmail(email);
	        loginEntity.setPassword(password);

	        try {
	            if (loginDao.validate(loginEntity)) {
	                session.setAttribute("nom", ie.getEtudiantByEmail(email).getNom());
	                session.setAttribute("email",email);
	                session.setAttribute("role","etudiant");
	            //  response.sendRedirect("etudiant.jsp");
	                request.setAttribute("idEtudiant", ie.getEtudiantByEmail(email).getMatricule());
	                
	           request.getRequestDispatcher("portfolio.jsp").forward(request, response);
	            } else {
					/*
					 * HttpSession session = request.getSession(); session.setAttribute("email",
					 * email);
					 */
	            	session.invalidate();
					request.getRequestDispatcher("loginEtudiant.jsp").forward(request, response);
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	}