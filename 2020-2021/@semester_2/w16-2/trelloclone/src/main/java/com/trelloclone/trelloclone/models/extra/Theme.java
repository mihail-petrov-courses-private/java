package com.trelloclone.trelloclone.models.extra;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.trelloclone.trelloclone.models.pm.Board;

@Entity
@Table(name = "tm_theme")
public class Theme {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public String title;
	
	@OneToMany(mappedBy = "theme")
	private List<Board> boards;
}
