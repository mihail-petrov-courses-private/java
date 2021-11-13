package com.trelloclone.trelloclone.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.trelloclone.trelloclone.models.pm.Board;
import com.trelloclone.trelloclone.models.pm.BoardList;
import com.trelloclone.trelloclone.models.pm.Card;
import com.trelloclone.trelloclone.services.data.BoardDataService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDataService boardDataService;
	
	@GetMapping("/boards/{id}")
	public String getBoardPage(@PathVariable int id, Model model) {
		
		var boardListCollection = this.boardDataService.getBoardLists(id);
		
		model.addAttribute("boardId"				, id);
		model.addAttribute("boardList"				, new BoardList());
		model.addAttribute("card"					, new Card());
		model.addAttribute("boardListCollection"	, boardListCollection);
		return "board/view";
	}
	
	@PostMapping("/boards/{id}")
	public RedirectView processBoard(
		@ModelAttribute BoardList entity, 
		@PathVariable int id
	) {
		this.boardDataService.createBoardList(entity, id);
		return new RedirectView("/boards/" + id);
	}
	
	@PostMapping("/boards/{boardId}/card/{boardListId}/create")
	public RedirectView createCard(
			@PathVariable int boardId,
			@PathVariable int boardListId,
			@ModelAttribute Card entity) {
		
		this.boardDataService.createCard(entity, boardListId);
		return new RedirectView("/boards/" + boardId);
	}
}
