package beans;

import java.io.Serializable;

public class UserBean implements Serializable {
	/**
	 * @author Stefan
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String password;
	
	public UserBean() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
