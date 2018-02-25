package com.beans;

import java.io.Serializable;
/**
 * Clasa bean folosita pentru reprezentarea utilizatorului.
 * @author Stefan
 * @category Bean
 */
public class UserBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String password;
	
	public UserBean() {
	}
	/**
	 * Metoda ce returneaza numele utilizatorului setat in obiect.
	 * @return numele utilizatorului
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Metoda ce returneaza parola utilizatorului setat in obiect.
	 * @return parola utilizatorului
	 */
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
