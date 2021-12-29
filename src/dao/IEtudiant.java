package dao;

import java.util.List;

import metier.entities.Etudiant;


public interface IEtudiant {
	
public Etudiant save(Etudiant e);
public boolean estIlAffecterAuneSessionDonnee(int idEtudiant,int idSession);
public List<Etudiant> toutEtudiants();
public List<Etudiant> chercherEtudiantParNom(String n);
public Etudiant getEtudiantByEmail(String email) ;
public boolean estIlAffecter(int id);

public Etudiant getEtudiant(int id);

public Etudiant update(Etudiant e);

public void deleteEtudiant(int id);
public List<Integer> getEtudiantsNonAffecterASessionDonnee(int id);


	
}
