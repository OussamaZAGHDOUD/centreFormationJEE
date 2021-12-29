package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import metier.entities.Affectation;
import metier.entities.Etudiant;
import metier.entities.Reservation;
import metier.entities.Session;

public class ReservationDaoImpl implements IReservation {

	@Override
	public void save(int e, int	s) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO RESERVATION (IDSESSION,IDETUDIANT,DATERESERVATION) VALUES(?,?,?)");
			ps.setInt(1, s);
			ps.setInt(2, e);
			ps.setString(3, LocalDate.now().toString());


			ps.executeUpdate();

			ps.close();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		

	}

	@Override
	public List<Integer> consulterListeDesReservationsPourUnEtudiant(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, ArrayList<Integer>> consulterToutesLesReservation() {
HashMap<Integer, ArrayList<Integer>> h=new HashMap<Integer, ArrayList<Integer>>();

Connection connection = SingletonConnection.getConnection();

try {
	PreparedStatement ps = connection.prepareStatement("SELECT DISTINCT IDETUDIANT FROM RESERVATION ");
	ResultSet rs = ps.executeQuery();
	while (rs.next()) {
		
		int idEtudiant = rs.getInt("IDETUDIANT");
h.put(idEtudiant, new ArrayList<>());


	}	
		h.forEach((a,b)->{  
						
			try {
				PreparedStatement ps1 = connection.prepareStatement("SELECT  IDSESSION FROM RESERVATION WHERE IDETUDIANT=? ");
				ps1.setInt(1, a);
				ResultSet rs1 = ps1.executeQuery();
				while (rs1.next()) {
					
				
					int idSession = rs1.getInt("IDSESSION");
					b.add(idSession);
				}
} catch (SQLException ex) {
	// TODO Auto-generated catch block
	ex.printStackTrace();
}
			
		
	;});

}
catch (SQLException ex) {
	// TODO Auto-generated catch block
	ex.printStackTrace();
}
return h;
			
	}
	


	public void deleteReservation(int idEtudiant,int idSession) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM RESERVATION WHERE IDETUDIANT=? AND IDSESSION=?");
			ps.setInt(1, idEtudiant);
			ps.setInt(2, idSession);
		    ps.executeUpdate();
		    ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
