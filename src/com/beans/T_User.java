package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ch_user")
public class T_User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CH_USER_ID")
	private int id;
	@Column(name="CH_USER_NAME")
	private String nume;
	@Column(name="CH_USER_SURNAME")
	private String prenume;
	@Column(name="CH_USER_SEX")
	private String sex;
	@Column(name="CH_USER_EMAIL")
	private String email;
	@Column(name="CH_USER_PASS")
	private String password;	
	@Column(name="CH_USER_IP")
	private String ip;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	
}
