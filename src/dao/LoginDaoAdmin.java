package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Admin;
import metier.entities.Etudiant;
import metier.entities.LoginEntity;


public class LoginDaoAdmin implements ILoginAdmin {
	
	public Admin save(String email,String role,String password) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection
				.prepareStatement("INSERT INTO login (email,role,password) VALUES(?,?,?)");
			ps.setString(1, email);
			ps.setString(2, role);
			ps.setString(3, password);
			ps.executeUpdate();
		
			ps.close();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return(new Admin(email,role,password));
	}
	
	
	
	
	public List<Admin> chercherAdminParEmail(String email) {
		List<Admin> admins =new ArrayList<Admin>();
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= connection.prepareStatement("SELECT * FROM login WHERE email LIKE ?");
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{	
				Admin a =new Admin();
				a.setEmail(rs.getString("email"));
				a.setPassword(rs.getString("password"));
				a.setRole(rs.getString("role"));
				admins.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admins;
			}
	
	
	
	
	public String getRole(LoginEntity l) {
		Connection connection=SingletonConnection.getConnection();
		String role=null;
		try {
			PreparedStatement ps= connection.prepareStatement("SELECT role FROM login WHERE email LIKE ?");
			ps.setString(1, l.getEmail());
			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{				
				role=rs.getString("role");
}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return role;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public void deleteFromLoginTable(String email) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM login WHERE email = ?");
			ps.setString(1, email);
		    ps.executeUpdate();
		    ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<Admin> toutAdmins() {
		List<Admin> admins =new ArrayList<Admin>();
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= connection.prepareStatement("SELECT * FROM login");
			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{				
				Admin a =new Admin();
				a.setEmail(rs.getString("email"));
				a.setPassword(rs.getString("password"));
				a.setRole(rs.getString("role"));
			
				admins.add(a);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admins;
			}
	
	

    public boolean validate(LoginEntity loginEntity) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

		Connection connection=SingletonConnection.getConnection();
try {

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from login where email = ? and password = ? ");
            preparedStatement.setString(1, loginEntity.getEmail());
            preparedStatement.setString(2, loginEntity.getPassword());

            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }

        return status;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}