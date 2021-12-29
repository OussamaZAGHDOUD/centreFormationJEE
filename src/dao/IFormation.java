package dao;

import java.util.List;

import metier.entities.Formation;

public interface IFormation {

public Formation save(Formation m);
public boolean contientElleDesSession(int id);
public Formation getFormation(int id);
public Formation getFormationByNom(String nom);
public Formation update(Formation m);

public void deleteFormation(int id);
public List<Formation> chercherFormationParNom(String nom) ;
public List<Formation> tousFormation();
	
	
}
