package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import metier.entities.Etudiant;
import metier.entities.Reservation;
import metier.entities.Session;

public interface IReservation {
	public void save(int e,int	s);
	public List<Integer> consulterListeDesReservationsPourUnEtudiant(int id) ;
	public HashMap<Integer, ArrayList<Integer>> consulterToutesLesReservation() ;
	public void deleteReservation(int idEtudiant,int idSession) ;


}
