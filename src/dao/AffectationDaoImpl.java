package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Affectation;
import metier.entities.Etudiant;
import metier.entities.Session;

public class AffectationDaoImpl implements IAffectation {

	@Override
	public Affectation save(Etudiant e, Session m) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO Affectation (IDSESSION,IDETUDIANT) VALUES(?,?)");
			ps.setInt(1, m.getIdSession());
			ps.setInt(2, e.getMatricule());


			ps.executeUpdate();

			ps.close();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		Affectation a = new Affectation(m.getIdSession(), e.getMatricule());

		return a;

	}

	public List<Integer> consulter(int idSession) {
		Connection connection = SingletonConnection.getConnection();
		Etudiant e;
		List<Etudiant> lst = new ArrayList<Etudiant>();
		List<Integer> l = new ArrayList<Integer>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT IDETUDIANT FROM Affectation WHERE IDSESSION=?");
			ps.setInt(1, idSession);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {/*
								 * e.get e =new Etudiant(); e.setMatricule(rs.getInt("MATRICULE"));
								 * e.setNom(rs.getString("NOM")); e.setNumTel(rs.getLong("NUMTEL"));
								 * e.setAdresse(rs.getString("ADRESSE")); lst.add(e);
								 */
				int idEtudiant = rs.getInt("IDETUDIANT");
				l.add(idEtudiant);
			}

			ps.close();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return l;

	}
	
	public List<Integer> consulterListeDesSessionsPourUnEtudiant(int id) {
		Connection connection = SingletonConnection.getConnection();
		List<Integer> l = new ArrayList<Integer>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT IDSESSION FROM Affectation WHERE IDETUDIANT=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
								
				int idSession = rs.getInt("IDSESSION");
				l.add(idSession);
			}

			ps.close();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return l;

	}


	

}
