package com.trelloclone.trelloclone.models.pm;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
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
	@JoinColumn(name="boardlist_id", insertable = false, updatable = false )
	@ManyToOne
	private BoardList boardlist;
	
	@Column(name = "boardlist_id")
	private int boardListId;
	
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

	public int getBoardListId() {
		return boardListId;
	}

	public void setBoardListId(int boardListId) {
		this.boardListId = boardListId;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
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
	
	public void setMembers(User singleMember) {
		
		ArrayList<User> userCollection = new ArrayList<>();
		userCollection.add(singleMember);
		this.members = userCollection;
	}	
}
