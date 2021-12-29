
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.MediaSize.ISO;

import metier.entities.Etudiant;
import metier.entities.Formation;

public class FormationDaoImpl implements IFormation {

	public Formation save(Formation m) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO FORMATION (NOMFORMATION,NBRJOUR) VALUES(?,?)");
			ps.setString(1, m.getNomFormation());
			ps.setInt(2, m.getNbrJour());
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(IDFORMATION) AS MAXID FROM FORMATION");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				m.setIdFormation(rs.getInt("MAXID"));
			}
			ps.close();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return m;
	}

	public Formation getFormation(int id) {
		Formation m = null;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM FORMATION WHERE IDFORMATION=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				m = new Formation();
				m.setIdFormation(rs.getInt("IDFORMATION"));
				m.setNomFormation(rs.getString("NOMFORMATION"));
				m.setNbrJour(rs.getInt("NBRJOUR"));

			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return m;
	}
	
	
	

	public Formation update(Formation m) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE  FORMATION SET NOMFORMATION=?,NBRJOUR=? WHERE IDFORMATION=?");
			ps.setString(1, m.getNomFormation());
			ps.setInt(2, m.getNbrJour());
			ps.setInt(3, m.getIdFormation());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return m;
	}

	public void deleteFormation(int id) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM FORMATION WHERE IDFORMATION = ?");
			ps.setInt(1, id);
		    ps.executeUpdate();
		    ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Formation> chercherFormationParNom(String nom) {
		List<Formation> Formations =new ArrayList<Formation>();
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= connection.prepareStatement("SELECT * FROM FORMATION WHERE NOMFORMATION LIKE ?");
			ps.setString(1, nom);
			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{		Formation m=new Formation();	
			m.setIdFormation(rs.getInt("IDFORMATION"));
			m.setNomFormation(rs.getString("NOMFORMATION"));
			m.setNbrJour(rs.getInt("NBRJOUR"));
			Formations.add(m);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Formations;
			}
	
	
	
	public List<Formation> tousFormation() {
		List<Formation> Formations =new ArrayList<Formation>();
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps= connection.prepareStatement("SELECT * FROM FORMATION");
			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{		Formation m=new Formation();	
			m.setIdFormation(rs.getInt("IDFORMATION"));
			m.setNomFormation(rs.getString("NOMFORMATION"));
			m.setNbrJour(rs.getInt("NBRJOUR"));
			Formations.add(m);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Formations;
			}

	public Formation getFormationByNom(String nom) {
		Formation m = null;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM FORMATION WHERE NOMFORMATION=?");
			ps.setString(1, nom);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				m = new Formation();
				m.setIdFormation(rs.getInt("IDFORMATION"));
				m.setNomFormation(rs.getString("NOMFORMATION"));
				m.setNbrJour(rs.getInt("NBRJOUR"));

			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return m;
	}

	
	
	
	public boolean contientElleDesSession(int id)
	{
		int i=0;
			Connection connection=SingletonConnection.getConnection();
			try {
				PreparedStatement ps= connection.prepareStatement("SELECT IDFORMATION FROM SESSION WHERE IDFORMATION=?");
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
