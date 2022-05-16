package com.trelloclone.trelloclone.models.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.trelloclone.trelloclone.models.extra.Comment;
import com.trelloclone.trelloclone.models.pm.Board;
import com.trelloclone.trelloclone.models.pm.Card;
import com.trelloclone.trelloclone.models.pm.Workspace;

@Entity
@Table(name="td_users")
public class User {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	// Relation -- One To Many
	// ***
	@OneToMany(mappedBy = "owner")
	private List<Workspace> workspaces;
	
	@OneToMany(mappedBy = "owner")
	private List<Card> cards;
	
	@OneToMany(mappedBy = "owner")
	private List<Comment> comments;
	
	// Relation -- Many To Many
	// ***
	@ManyToMany(mappedBy = "members")
	private List<Workspace> memberWorkspaces;
	
	@ManyToMany(mappedBy = "members")
	private List<Board> memberBoards;
	
	@ManyToMany(mappedBy = "members")
	private List<Card> memberCards;	
	
	public User() {}

	public Long getId() {
		return id;
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

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards= cards;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Workspace> getMemberWorkspaces() {
		return memberWorkspaces;
	}

	public void setMemberWorkspaces(List<Workspace> memberWorkspaces) {
		this.memberWorkspaces = memberWorkspaces;
	}

	public List<Board> getMemberBoards() {
		return memberBoards;
	}

	public void setMemberBoards(List<Board> memberBoards) {
		this.memberBoards = memberBoards;
	}

	public List<Card> getMemberCards() {
		return memberCards;
	}

	public void setMemberCards(List<Card> memberCards) {
		this.memberCards = memberCards;
	}
}
