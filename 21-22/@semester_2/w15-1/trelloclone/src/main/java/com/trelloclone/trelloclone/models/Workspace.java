package com.trelloclone.trelloclone.models;

import com.trelloclone.trelloclone.enums.WorkspaceType;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="td_workspaces")
public class Workspace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;
	private WorkspaceType type;
	private String description;
	private List<User> users;
	
	public Workspace() {
		
	}
	
	public Workspace(String title, WorkspaceType type, String description) {
		this.title 			= title;
		this.type 			= type;
		this.description 	= description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public WorkspaceType getType() {
		return type;
	}

	public void setType(WorkspaceType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}	
}
