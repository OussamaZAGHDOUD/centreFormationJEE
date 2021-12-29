package metier.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.Formatter;

import javax.print.attribute.standard.MediaSize.ISO;
import javax.swing.text.DateFormatter;

public class Session {
	private int idSession;
	
	
	private int formationId;;
	private String nomEnseignant;
	private int nmbrSeanceParJour;
	private LocalDate dateDebut;
	private String statut;
	
	
public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
public int getIdSession() {
		return idSession;
	}
	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}


public void setDateDebut(LocalDate dateDebut) {
	this.dateDebut = dateDebut;
}
public int getNmbrSeanceParJour() {
	return nmbrSeanceParJour;
}
public void setNmbrSeanceParJour(int nmbrSeanceParJour) {
	this.nmbrSeanceParJour = nmbrSeanceParJour;
}
public LocalDate getDateDebut() {
	return dateDebut;
}
public void setDateDebut(String dateDebut) {
	this.dateDebut = LocalDate.parse(dateDebut);
}

public String getNomEnseignant() {
	return nomEnseignant;
}
public void setNomEnseignant(String nomEnseignant) {
	this.nomEnseignant = nomEnseignant;
}

public Session(int formationId, String nomEnseignant,String dated, int nmbrSeanceParJour) {
	super();
	this.formationId = formationId;
	this.nomEnseignant = nomEnseignant;
	this.nmbrSeanceParJour = nmbrSeanceParJour;
	this.dateDebut=LocalDate.parse(dated);
	
}
@Override
public String toString() {
	return "Enseignant=" + nomEnseignant
			+ "   Nombre des seances par jour=" + nmbrSeanceParJour + "   Date de début=" + dateDebut + "]";
}
public int getFormationId() {
	return formationId;
}
public void setFormationId(int formationId) {
	this.formationId = formationId;
}
public Session() {
	super();
	// TODO Auto-generated constructor stub
}


}
