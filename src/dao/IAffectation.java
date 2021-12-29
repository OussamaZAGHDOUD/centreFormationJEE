package dao;

import java.util.List;

import metier.entities.Affectation;
import metier.entities.Etudiant;
import metier.entities.Session;

public interface IAffectation {

	public Affectation save(Etudiant e,Session m);
	public List<Integer> consulter(int idSession);

	public List<Integer> consulterListeDesSessionsPourUnEtudiant(int id) ;
}
