package com.trelloclone.trelloclone.models.pm;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.trelloclone.trelloclone.models.extra.Comment;
import com.trelloclone.trelloclone.models.users.User;

@Entity
@Table(name="td_cards")
public class Card {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String description;
	
	// Entity relation
	@ManyToOne
	private BoardList boardlist;
	
	@ManyToOne
	private User owner;
	
	@OneToMany(mappedBy = "card")
	private List<Comment> comments;
	
	@ManyToMany
	@JoinTable(
		name 				= "tc_card_members",
		joinColumns 		= @JoinColumn(name="card_id"),
		inverseJoinColumns 	= @JoinColumn(name="user_id")
	)
	private List<User> members;
	
	public Card() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BoardList getBoardlist() {
		return boardlist;
	}

	public void setBoardlist(BoardList boardlist) {
		this.boardlist = boardlist;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
}
