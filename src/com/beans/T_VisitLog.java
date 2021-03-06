package com.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ch_visitlog")
public class T_VisitLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CH_VISITLOG_ID")
	private int id;
	@Column(name="CH_VISITLOG_IP")
	private String ip;
	@Column(name="CH_VISITLOG_BROWSER")
	private String browserName;
	@Column(name="CH_VISITLOG_BROWSER_VER")
	private String browerVersion;
	@Column(name="CH_VISITLOG_OS")
	private String os;
	@Column(name="CH_VISITLOG_DATE")
	private Date date;
	@Column(name="CH_VISITLOG_PAGE")
	private String visitLogPage;
	@Column(name="CH_VISITLOG_PAGE_ERR")
	private String visitLogPageErr;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getBrowserName() {
		return browserName;
	}
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}
	public String getBrowerVersion() {
		return browerVersion;
	}
	public void setBrowerVersion(String browerVersion) {
		this.browerVersion = browerVersion;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getVisitLogPage() {
		return visitLogPage;
	}
	public void setVisitLogPage(String visitLogPage) {
		this.visitLogPage = visitLogPage;
	}
	public String getVisitLogPageErr() {
		return visitLogPageErr;
	}
	public void setVisitLogPageErr(String visitLogPageErr) {
		this.visitLogPageErr = visitLogPageErr;
	}
	
	
}
