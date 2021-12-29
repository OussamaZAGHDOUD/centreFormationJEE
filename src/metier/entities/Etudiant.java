package metier.entities;

public class Etudiant {
	@Override
	public String toString() {
		return "Etudiant [matricule=" + matricule + ", numTel=" + numTel + ", nom=" + nom + ", adresse=" + adresse
				+ "]";
	}
	private int matricule;
	private Long numTel;
	private String nom;
	private String adresse;
	private String email;
public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		
		
		
		this.email = email;
	}
public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
public Etudiant(Long numTel, String nom, String adresse,String email) {
		super();
		this.numTel = numTel;
		this.nom = nom;
		this.adresse = adresse;
		this.email=email;
	}
public int getMatricule() {
		return matricule;
	}
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

public Long getNumTel() {
	return numTel;
}
public void setNumTel(Long numTel) {
	this.numTel = numTel;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}

}
