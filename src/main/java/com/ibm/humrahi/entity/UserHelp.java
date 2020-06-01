package com.ibm.humrahi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_HELP")
public class UserHelp {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_ID", nullable = false)
	private User User;	
	
	@Column(name = "help_id")
	private long helpId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
	}

	public long getHelpId() {
		return helpId;
	}

	public void setHelpId(long helpId) {
		this.helpId = helpId;
	}

}
