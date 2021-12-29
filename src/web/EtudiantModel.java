package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Etudiant;


public class EtudiantModel {

		private String nomEtudiant;
		private List<Etudiant> etudiants =new ArrayList<Etudiant>();
		public String getNomEtudiant() {
			return nomEtudiant;
		}
		public List<Etudiant> getEtudiants() {
			return etudiants;
		}
		public void setEtudiants(List<Etudiant> etudiants) {
			this.etudiants = etudiants;
		}
		public void setNomEtudiant(String nomEtudiant) {
			this.nomEtudiant = nomEtudiant;
		}
		
		
		

}
