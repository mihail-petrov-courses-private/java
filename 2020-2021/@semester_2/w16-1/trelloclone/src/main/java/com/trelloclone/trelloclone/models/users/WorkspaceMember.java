package com.trelloclone.trelloclone.models.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.trelloclone.trelloclone.models.pm.Workspace;

//@Entity
//@Table(name = "tc_workspace_members")
public class WorkspaceMember {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// user
	@ManyToOne
	private Workspace workspace;
	
	// workspace
	@ManyToOne
	private User user;
	
	// is active
	@ColumnDefault("true")
	private boolean isActive;
}
