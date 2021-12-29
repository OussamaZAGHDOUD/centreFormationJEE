package web;


	import java.io.IOException;


	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

import dao.LoginDao;
import dao.LoginDaoAdmin;
import metier.entities.LoginEntity;



	@WebServlet("*.login")
	public class LoginControlleur  extends HttpServlet {
	    private LoginDao loginDao;
	    private LoginDaoAdmin loginDaoAdmin;

	    public void init() {
	        loginDao = new LoginDao();
	        loginDaoAdmin=new LoginDaoAdmin();
	    }
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	// TODO Auto-generated method stub
			HttpSession session=request.getSession();
			
			if(session.getAttribute("role")=="admin"||session.getAttribute("role")=="assistant")
			request.getRequestDispatcher("home.jsp").forward(request, response);
			else
			{
			session.invalidate();
			request.getRequestDispatcher("adminLogin.html").forward(request, response);    
			}
			}
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	    
	    	String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        LoginEntity loginEntity = new LoginEntity();

	        loginEntity.setEmail(email);
	        loginEntity.setPassword(password);
            String role= loginDaoAdmin.getRole(loginEntity);
            loginEntity.setRole(role);

	        try {
	            if (loginDao.validate(loginEntity)) {
	                HttpSession session = request.getSession();
	                session.setAttribute("email",email);
	                session.setAttribute("role",role);
	              //  response.sendRedirect("home.jsp");
	        request.getRequestDispatcher("home.jsp").forward(request, response);
	            } else {
						request.getRequestDispatcher("adminLogin.html").forward(request, response);
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	}