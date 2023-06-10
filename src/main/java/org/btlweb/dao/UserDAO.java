package org.btlweb.dao;

import java.util.List;

import org.btlweb.model.UserLogin;

public interface UserDAO {
	void add(UserLogin UserLogin);

	void update(UserLogin UserLogin);

	void delete(int id);

	UserLogin get(int id);// duy nhat

	UserLogin getByUsername(String username);// duy nhat
	
	boolean checkUsernameExists(String username);

	boolean checkEmail(String email);

	void updatePassword(String email, String newPassword);
	
	boolean checkUsername(String email, String password) ;

	List<UserLogin> search(String name);

	List<UserLogin> getAllUsers();

	int dayLogin(int id);
	int hourFocus(int id);
}