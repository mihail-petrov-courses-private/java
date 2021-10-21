package com.trelloclone.trelloclone.models.pm;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity()
@Table(name="td_boards")
public class Board {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
		
	// TODO
	// relation with : tm_visibility
	private boolean isVisble;
	
	// TODO
	// relation with : tm_themes
	private String theme;
	
	// Relation properties
	@ManyToOne
	private Workspace workspace;
	
	@OneToMany
	private List<BoardList> boardlist;
	
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

	public boolean isVisble() {
		return isVisble;
	}

	public void setVisble(boolean isVisble) {
		this.isVisble = isVisble;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Workspace getWorkspace() {
		return workspace;
	}

	public void setWorkspace(Workspace workspace) {
		this.workspace = workspace;
	}

	public List<BoardList> getBoardlist() {
		return boardlist;
	}

	public void setBoardlist(List<BoardList> boardlist) {
		this.boardlist = boardlist;
	}
}
