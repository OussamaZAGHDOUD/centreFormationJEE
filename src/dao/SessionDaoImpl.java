package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.MediaSize.ISO;

import metier.entities.Etudiant;
import metier.entities.Session;

public class SessionDaoImpl implements ISession {

	
	
	public Session save(Session s) {
		Connection connection = SingletonConnection.getConnection();
		try {					
		PreparedStatement ps = connection.prepareStatement(
				"INSERT INTO SESSION (IDFORMATION,NOMENSEIGNANT,DATEDEBUT,NOMBRESEANCEPARJOUR,STATUT) VALUES(?,?,?,?,?)");
		ps.setInt(1, s.getFormationId());
		ps.setString(2, s.getNomEnseignant());
		ps.setString(3, s.getDateDebut().toString());
		ps.setInt(4, s.getNmbrSeanceParJour());
		ps.setString(5, "Programmée");

		
		ps.executeUpdate();
		PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(IDSESSION) AS MAXID FROM SESSION");
		ResultSet rs = ps2.executeQuery();
		if (rs.next()) {
			s.setIdSession(rs.getInt("MAXID"));
		}
		ps.close();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return s;
	}

	public Session getSession(int id) {
		Session m = null;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM SESSION WHERE IDSESSION=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				m = new Session();
				m.setIdSession(rs.getInt("IDSESSION"));
				m.setFormationId(rs.getInt("IDFORMATION"));
				m.setNomEnseignant(rs.getString("NOMENSEIGNANT"));
				m.setDateDebut(rs.getDate("DATEDEBUT").toString());
				m.setNmbrSeanceParJour(rs.getInt("NOMBRESEANCEPARJOUR"));
				m.setStatut(rs.getString("STATUT"));
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return m;
	}
	
	public String getSessionNom(int id) {
		String s=null;
		Connection connection = SingletonConnection.getConnection();
		try {

			PreparedStatement ps = connection.prepareStatement("SELECT NOMFORMATION FROM FORMATION F, SESSION S WHERE IDSESSION=? AND F.IDFORMATION=S.IDFORMATION");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
			s=rs.getString("NOMFORMATION");
	}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return s;
	}
	
	public int getSessionNbrJour(int id) {
		int s=0;
		Connection connection = SingletonConnection.getConnection();
		try {

			PreparedStatement ps = connection.prepareStatement("SELECT F.NBRJOUR FROM FORMATION F, SESSION S WHERE IDSESSION=? AND F.IDFORMATION=S.IDFORMATION");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				s=rs.getInt("NBRJOUR");
	}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return s;
	}
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public Session update(Session m) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE  SESSION SET NOMENSEIGNANT=?,DATEDEBUT=?,NOMBRESEANCEPARJOUR=? WHERE IDSESSION=?");
			ps.setString(1, m.getNomEnseignant());
			ps.setString(2, m.getDateDebut().toString());
			ps.setInt(3, m.getNmbrSeanceParJour());
			ps.setInt(4, m.getIdSession());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return m;
	}
	
	
	public Session update(Session m, String statut) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE  SESSION SET NOMENSEIGNANT=?,DATEDEBUT=?,NOMBRESEANCEPARJOUR=?,STATUT=? WHERE IDSESSION=?");
			ps.setString(1, m.getNomEnseignant());
			ps.setString(2, m.getDateDebut().toString());
			ps.setInt(3, m.getNmbrSeanceParJour());
			ps.setString(4, statut);
			ps.setInt(5, m.getIdSession());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return m;
	}
	
	
	

	public void deleteSession(int id) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM SESSION WHERE IDSESSION = ?");
			ps.setInt(1, id);
		    ps.executeUpdate();
		    ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Session> chercherSessionParIdFormation(int id) {
		List<Session> sessions =new ArrayList<Session>();
		Connection connection=SingletonConnection.getConnection();
		
		
		try {
			PreparedStatement ps= connection.prepareStatement("SELECT * FROM SESSION WHERE IDFORMATION=? ORDER BY DATEDEBUT DESC");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{		Session m=new Session();	
			m.setIdSession(rs.getInt("IDSESSION"));
			m.setFormationId(rs.getInt("IDFORMATION"));
			m.setNomEnseignant(rs.getString("NOMENSEIGNANT"));
			m.setDateDebut(rs.getDate("DATEDEBUT").toString());
			m.setNmbrSeanceParJour(rs.getInt("NOMBRESEANCEPARJOUR"));
			m.setStatut(rs.getString("STATUT"));


			sessions.add(m);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sessions;
			}
	
	
	
	public List<Session> tousSession() {
		List<Session> sessions =new ArrayList<Session>();
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= connection.prepareStatement("SELECT * FROM SESSION ORDER BY DATEDEBUT DESC");
			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{		Session m=new Session();	
			m.setIdSession(rs.getInt("IDSESSION"));
			m.setFormationId(rs.getInt("IDFORMATION"));
			m.setNomEnseignant(rs.getString("NOMENSEIGNANT"));
			m.setDateDebut(rs.getDate("DATEDEBUT").toString());
			m.setNmbrSeanceParJour(rs.getInt("NOMBRESEANCEPARJOUR"));
			m.setStatut(rs.getString("STATUT"));


			sessions.add(m);
			
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sessions;
			}

	public Session getSession(String nom) {
		Session m = null;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM SESSION WHERE NOMSESSION=?");
			ps.setString(1, nom);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				m = new Session();
				m.setIdSession(rs.getInt("IDSESSION"));
				m.setFormationId(rs.getInt("IDFORMATION"));
				m.setNomEnseignant(rs.getString("NOMENSEIGNANT"));
				m.setDateDebut(rs.getDate("DATEDEBUT").toString());
				m.setNmbrSeanceParJour(rs.getInt("NOMBRESEANCEPARJOUR"));
				m.setStatut(rs.getString("STATUT"));



			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return m;
	}
	
	public List<Integer> SessionTerminee() {
		Connection connection = SingletonConnection.getConnection();
		List<Integer> l = new ArrayList<Integer>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT S.IDSESSION AS IDSESSION FROM SESSION S,FORMATION F WHERE S.IDFORMATION=F.IDFORMATION AND (DATE_ADD(S.DATEDEBUT, INTERVAL F.NBRJOUR DAY )<(SELECT CURRENT_DATE FROM DUAL))");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("IDSESSION");
				l.add(id);
			}
			ps.close();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return l;
	}
	
	
	
	public List<Integer> SessionEnCours() {
		Connection connection = SingletonConnection.getConnection();
		List<Integer> l = new ArrayList<Integer>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT S.IDSESSION AS IDSESSION FROM SESSION S,FORMATION F WHERE S.IDFORMATION=F.IDFORMATION AND (DATE_ADD(S.DATEDEBUT, INTERVAL F.NBRJOUR DAY)>=(SELECT CURRENT_DATE FROM DUAL)) AND S.DATEDEBUT<=(SELECT CURRENT_DATE FROM DUAL)");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("IDSESSION");
				l.add(id);
			}
			ps.close();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		return l;
	}
	
	
	

	public boolean contientElleDesEtudiants(int id)
	{
		int i=0;
			Connection connection=SingletonConnection.getConnection();
			try {
				PreparedStatement ps= connection.prepareStatement("SELECT IDETUDIANT FROM Affectation WHERE IDSESSION=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				while (rs.next())
				{				
					i++;					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(i==0)
				return false;
				else 
					return true;
		
	}
	
	
}
