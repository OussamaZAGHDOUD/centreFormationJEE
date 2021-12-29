package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Session;

public class SessionModel {

	private String nomSession;
	private List<String> nomFormations=new ArrayList<String>();
	private List<Session> liste=new ArrayList<Session>();
	public List<Session> getListe() {
		return liste;
	}
	public void setListe(List<Session> liste) {
		this.liste = liste;
	}
	public List<String> getNomFormations() {
		return nomFormations;
	}
	public void setNomFormations(List<String> nomFormations) {
		this.nomFormations = nomFormations;
	}
	private List<Session> Sessions =new ArrayList<Session>();

	public String getNomSession() {
		return nomSession;
	}
	public void setNomSession(String nomSession) {
		this.nomSession = nomSession;
	}
	public List<Session> getSessions() {
		return Sessions;
	}
	public void setSessions(List<Session> metieres) {
		this.Sessions = metieres;
	}
}
