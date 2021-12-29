package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.entities.Etudiant;
import metier.entities.LoginEntity;


public class LoginDao implements ILogin {
	
	public void save(String email,String password,String role) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection
				.prepareStatement("INSERT INTO login (email,password,role) VALUES(?,?,?)");
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, role);
			ps.executeUpdate();
		
			ps.close();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
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