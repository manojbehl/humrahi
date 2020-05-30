package com.ibm.humrahi.entity;

import java.util.Set;

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
@Table(name="MIGRANT_HELP")
public class MigrantHelp {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Migrant_ID", nullable = false)
	private Migrant migrant;	
	
	@Column(name = "help_id")
	private long helpId;


	public long getHelpId() {
		return helpId;
	}

	public void setHelpId(long helpId) {
		this.helpId = helpId;
	}

	public Migrant getMigrant() {
		return migrant;
	}

	public void setMigrant(Migrant migrant) {
		this.migrant = migrant;
	}

}
