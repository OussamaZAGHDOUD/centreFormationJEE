package dao;

import java.util.List;

import metier.entities.Etudiant;
import metier.entities.Session;

public interface ISession {

	public String getSessionNom(int id) ;
	public int getSessionNbrJour(int id);

public Session save(Session m);
public boolean contientElleDesEtudiants(int id);
public Session getSession(int id);
public Session getSession(String nom);

public Session update(Session m);

public void deleteSession(int id);
public List<Session> chercherSessionParIdFormation(int id) ;
public List<Session> tousSession();
public List<Integer> SessionTerminee();	
public List<Integer> SessionEnCours() ;
public Session update(Session m, String statut) ;
}
