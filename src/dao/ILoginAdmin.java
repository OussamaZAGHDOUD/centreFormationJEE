package dao;

import java.util.List;

import metier.entities.Admin;
import metier.entities.LoginEntity;

public interface ILoginAdmin {
	public Admin save(String email,String password,String role);
	public void deleteFromLoginTable(String email);
	public boolean validate(LoginEntity loginEntity) throws ClassNotFoundException;
	public List<Admin> toutAdmins() ;
	public List<Admin> chercherAdminParEmail(String email) ;
	public String getRole(LoginEntity l);
}
