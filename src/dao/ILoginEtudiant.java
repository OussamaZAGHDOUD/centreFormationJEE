package dao;

import metier.entities.LoginEntity;

public interface ILoginEtudiant {
	public void save(String email,String password,String role);
	public void deleteFromLoginTable(String email);
	public boolean validate(LoginEntity loginEntity) throws ClassNotFoundException;
	
    public boolean estIlInscritParSite(String email) throws ClassNotFoundException ;
}
