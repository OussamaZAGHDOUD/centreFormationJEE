package metier.entities;

public class Reservation {

	private int idEtudiant;
	private int idSession ;
	public int getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public int getIdSession() {
		return idSession;
	}
	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}
	public Reservation(int idEtudiant, int idSession) {
		super();
		this.idEtudiant = idEtudiant;
		this.idSession = idSession;
	}
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
