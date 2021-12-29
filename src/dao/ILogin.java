package dao;

import metier.entities.LoginEntity;

public interface ILogin {
	public void save(String email,String password,String role);
	public boolean validate(LoginEntity loginEntity) throws ClassNotFoundException;
	
	
}
