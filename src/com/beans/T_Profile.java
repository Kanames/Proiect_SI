package com.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ch_profile")
public class T_Profile {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CH_PRF_ID")
	private int id;
	@Column(name="CH_PRF_PRIVATE")
	private Integer isPrivate;
	@Column(name="CH_PRF_STATUS")
	private String status;
	@Column(name="CH_PRF_PICTURE")
	private String urlPicture;
	@Column(name="CH_PRF_MSGNR_SENT")
	private Integer numarMesajeTrimise;
	@Column(name="CH_PRF_MSGNR_RECEIVE")
	private Integer numarMesajePrimite;
	@Column(name="CH_PRF_NICKNAME")
	private String nickname;
	@Column(name="CH_PRF_MODIFDATE")
	private Date dataModificariProfil;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getIsPrivate() {
		return isPrivate;
	}
	public void setIsPrivate(Integer isPrivate) {
		this.isPrivate = isPrivate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUrlPicture() {
		return urlPicture;
	}
	public void setUrlPicture(String urlPicture) {
		this.urlPicture = urlPicture;
	}
	public Integer getNumarMesajeTrimise() {
		return numarMesajeTrimise;
	}
	public void setNumarMesajeTrimise(Integer numarMesajeTrimise) {
		this.numarMesajeTrimise = numarMesajeTrimise;
	}
	public Integer getNumarMesajePrimite() {
		return numarMesajePrimite;
	}
	public void setNumarMesajePrimite(Integer numarMesajePrimite) {
		this.numarMesajePrimite = numarMesajePrimite;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getDataModificariProfil() {
		return dataModificariProfil;
	}
	public void setDataModificariProfil(Date dataModificariProfil) {
		this.dataModificariProfil = dataModificariProfil;
	}
	
	
	
}
