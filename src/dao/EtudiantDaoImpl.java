package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Etudiant;
public class EtudiantDaoImpl implements IEtudiant {

	public Etudiant save(Etudiant e) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection
				.prepareStatement("INSERT INTO ETUDIANT (NUMTEL,NOM,ADRESSE,EMAIL) VALUES(?,?,?,?)");
			ps.setLong(1, e.getNumTel());
			ps.setString(2, e.getNom());
			ps.setString(3, e.getAdresse());
			ps.setString(4, e.getEmail());
			ps.executeUpdate();
			PreparedStatement ps2=connection.prepareStatement("SELECT MAX(MATRICULE) AS MAXMAT FROM ETUDIANT");
			ResultSet rs=ps2.executeQuery();
			if(rs.next())
			{
				e.setMatricule(rs.getInt("MAXMAT"));
			}
			ps.close();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return e;
	}

	public List<Etudiant> toutEtudiants() {
		List<Etudiant> etudiants =new ArrayList<Etudiant>();
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= connection.prepareStatement("SELECT * FROM ETUDIANT");
			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{				
				Etudiant e =new Etudiant();
				e.setMatricule(rs.getInt("MATRICULE"));
				e.setNom(rs.getString("NOM"));
				e.setNumTel(rs.getLong("NUMTEL"));
				e.setAdresse(rs.getString("ADRESSE"));
				e.setEmail(rs.getString("EMAIL"));
				etudiants.add(e);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return etudiants;
			}
	
	
	
	
	
	
	

	public Etudiant getEtudiant(int id) {
		
		Etudiant e=null;

		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= connection.prepareStatement("SELECT * FROM ETUDIANT WHERE MATRICULE=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if (rs.next())
			{
				e =new Etudiant();
				e.setMatricule(rs.getInt("MATRICULE"));
				e.setNom(rs.getString("NOM"));
				e.setNumTel(rs.getLong("NUMTEL"));
				e.setAdresse(rs.getString("ADRESSE"));
				e.setEmail(rs.getString("EMAIL"));
				
			}

ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
return e;
		
	
	}

	public Etudiant update(Etudiant e) {
Connection connection=SingletonConnection.getConnection();

try {
	PreparedStatement ps=connection.prepareStatement("UPDATE ETUDIANT SET NOM=?,NUMTEL=?,ADRESSE=?,EMAIL=? WHERE MATRICULE=?");
	ps.setString(1, e.getNom());
	ps.setLong(2, e.getNumTel());
	ps.setString(3, e.getAdresse());
	ps.setString(4, e.getEmail());
	ps.setInt(5, e.getMatricule());
	ps.executeUpdate();
	ps.close();
	
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
return e;
	}
	public void deleteEtudiant(int id) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM ETUDIANT WHERE MATRICULE = ?");
			ps.setInt(1, id);
		    ps.executeUpdate();
		    ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	@Override
	public List<Etudiant> chercherEtudiantParNom(String nom) {
		List<Etudiant> etudiants =new ArrayList<Etudiant>();
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= connection.prepareStatement("SELECT * FROM ETUDIANT WHERE NOM LIKE ?");
			ps.setString(1, nom);
			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{				
				Etudiant e =new Etudiant();
				e.setMatricule(rs.getInt("MATRICULE"));
				e.setNom(rs.getString("NOM"));
				e.setNumTel(rs.getLong("NUMTEL"));
				e.setAdresse(rs.getString("ADRESSE"));
				e.setEmail(rs.getString("EMAIL"));
				etudiants.add(e);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return etudiants;
			}
	
	
	
	public Etudiant getEtudiantByEmail(String email) {
		Connection connection=SingletonConnection.getConnection();
		Etudiant e =new Etudiant();

		try {
			PreparedStatement ps= connection.prepareStatement("SELECT * FROM ETUDIANT WHERE EMAIL=?");
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{				
				e.setMatricule(rs.getInt("MATRICULE"));
				e.setNom(rs.getString("NOM"));
				e.setNumTel(rs.getLong("NUMTEL"));
				e.setAdresse(rs.getString("ADRESSE"));
				e.setAdresse(rs.getString("EMAIL"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e;
			}
	
	
	
	public List<Integer> getEtudiantsNonAffecterASessionDonnee(int id)
	{
			List<Integer> lst =new ArrayList<Integer>();
			Connection connection=SingletonConnection.getConnection();
			try {
				PreparedStatement ps= connection.prepareStatement("SELECT E.MATRICULE FROM ETUDIANT E WHERE E.MATRICULE NOT IN ( SELECT IDETUDIANT FROM Affectation WHERE IDSESSION=?)");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				while (rs.next())
				{				
					lst.add(rs.getInt("MATRICULE"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
		
		
		return lst;
		
	}
	
	public boolean estIlAffecter(int id)
	{int i=0;
			Connection connection=SingletonConnection.getConnection();
			try {
				PreparedStatement ps= connection.prepareStatement("SELECT IDETUDIANT FROM Affectation WHERE IDETUDIANT=?");
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
	
	
	
	
	public boolean estIlAffecterAuneSessionDonnee(int idEtudiant,int idSession)
	{int i=0;
			Connection connection=SingletonConnection.getConnection();
			try {
				PreparedStatement ps= connection.prepareStatement("SELECT IDETUDIANT FROM Affectation WHERE IDETUDIANT=? AND IDSESSION=?");
				ps.setInt(1, idEtudiant);
				ps.setInt(2, idSession);
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
