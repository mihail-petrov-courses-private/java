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

import com.trelloclone.trelloclone.enums.BoardVisibility;
import com.trelloclone.trelloclone.models.extra.Theme;
import com.trelloclone.trelloclone.models.users.User;

@Entity()
@Table(name="td_boards")
public class Board {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
		
	private BoardVisibility isVisble;
	
	@ManyToOne
	private Theme theme;
	
	// Relation properties
	@JoinColumn(name="workspace_id", insertable = false, updatable = false)
	@ManyToOne
	private Workspace workspace;
	
	@Column(name="workspace_id")
	private int workspaceId;
	
	@OneToMany(mappedBy = "board")
	private List<BoardList> boardlists;
	
	@ManyToMany
	@JoinTable(
		name				= "tc_board_members",
		joinColumns 		= @JoinColumn(name="board_id"),
		inverseJoinColumns 	= @JoinColumn(name="user_id") 
	)
	private List<User> members;
	
	
	public Board() {
		
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

	public Workspace getWorkspace() {
		return workspace;
	}

	public void setWorkspace(Workspace workspace) {
		this.workspace = workspace;
	}
	
	public int getWorkspaceId() {
		return workspaceId;
	}

	public void setWorkspaceId(int workspaceId) {
		this.workspaceId = workspaceId;
	}

	public List<BoardList> getBoardlist() {
		return boardlists;
	}

	public void setBoardlist(List<BoardList> boardlist) {
		this.boardlists = boardlist;
	}
	
	public BoardVisibility getIsVisble() {
		return this.isVisble;
	}

	public void setIsVisble(BoardVisibility isVisble) {
		this.isVisble = isVisble;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}	

	public List<BoardList> getBoardlists() {
		return boardlists;
	}

	public void setBoardlists(List<BoardList> boardlists) {
		this.boardlists = boardlists;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}
	
	public void setMembers(User singleMember) {
		
		ArrayList<User> userCollection = new ArrayList<>();
		userCollection.add(singleMember);
		this.members = userCollection;
	}	
}
