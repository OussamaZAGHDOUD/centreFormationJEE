package metier.entities;

import java.util.Formatter;

import javax.print.attribute.standard.MediaSize.ISO;

public class Formation {
	private int idFormation;
	private String nomFormation;
	private int nbrJour;
	public int getIdFormation() {
		return idFormation;
	}
	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}
	public String getNomFormation() {
		return nomFormation;
	}
	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
	}
	public int getNbrJour() {
		return nbrJour;
	}
	public void setNbrJour(int nbrJour) {
		this.nbrJour = nbrJour;
	}
	public Formation(String nomFormation, int nbrJour) {
		super();
		this.idFormation = idFormation;
		this.nomFormation = nomFormation;
		this.nbrJour = nbrJour;
	}
	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
