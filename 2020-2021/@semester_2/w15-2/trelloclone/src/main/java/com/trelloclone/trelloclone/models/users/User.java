package com.trelloclone.trelloclone.models.users;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.trelloclone.trelloclone.models.extra.Comment;
import com.trelloclone.trelloclone.models.pm.Card;
import com.trelloclone.trelloclone.models.pm.Workspace;

@Entity
@Table(name="td_users")
public class User {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	// Relation properties
	@OneToMany
	private List<Workspace> workspaces;
	
	@OneToMany
	private List<Card> boards;
	
	@OneToMany
	private List<Comment> comments;
	
	public User() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Workspace> getWorkspaces() {
		return workspaces;
	}

	public void setWorkspaces(List<Workspace> workspaces) {
		this.workspaces = workspaces;
	}

	public List<Card> getBoards() {
		return boards;
	}

	public void setBoards(List<Card> boards) {
		this.boards = boards;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
