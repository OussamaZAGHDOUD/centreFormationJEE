package metier.entities;

import java.time.LocalDate;

public class Affectation {

	private int idMatiere;
	private int idEtudiant;
	public int getIdMatiere() {
		return idMatiere;
	}
	public Affectation(int idMatiere, int idEtudiant) {
		super();
		this.idMatiere = idMatiere;
		this.idEtudiant = idEtudiant;
	}
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}
	public int getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	
	
	
}
