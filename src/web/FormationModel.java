package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Formation;

public class FormationModel {

	private String nomFormation;
	private List<Formation> Formations =new ArrayList<Formation>();
	Formation f;

	public Formation getF() {
		return f;
	}
	public void setF(Formation f) {
		this.f = f;
	}
	public String getNomFormation() {
		return nomFormation;
	}
	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
	}
	public List<Formation> getFormations() {
		return Formations;
	}
	public void setFormations(List<Formation> metieres) {
		this.Formations = metieres;
	}
}
