package com.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ch_message")
public class T_Message {

	@Id
	@Column(name="CH_MESS_ID")
	private int id;
	@Column(name="CH_MESS_BODY")
	private String bodyMsg;
	@Column(name="CH_MESS_TO_ID")
	private Integer receiverID;
	@Column(name="CH_MESS_TIME")
	private Timestamp messageTime;
	@Column(name="CH_MESS_STATUS")
	private Integer statusMsg;
	@Column(name="CH_MESS_FROM_ID")
	private Integer senderID;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBodyMsg() {
		return bodyMsg;
	}
	public void setBodyMsg(String bodyMsg) {
		this.bodyMsg = bodyMsg;
	}
	public Integer getReceiverID() {
		return receiverID;
	}
	public void setReceiverID(Integer receiverID) {
		this.receiverID = receiverID;
	}
	public Timestamp getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(Timestamp messageTime) {
		this.messageTime = messageTime;
	}
	public Integer getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(Integer statusMsg) {
		this.statusMsg = statusMsg;
	}
	public Integer getSenderID() {
		return senderID;
	}
	public void setSenderID(Integer senderID) {
		this.senderID = senderID;
	}
}
