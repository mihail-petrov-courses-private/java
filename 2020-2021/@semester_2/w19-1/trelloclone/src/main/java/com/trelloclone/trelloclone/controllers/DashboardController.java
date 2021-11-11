package com.trelloclone.trelloclone.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.trelloclone.trelloclone.models.pm.Board;
import com.trelloclone.trelloclone.models.pm.Workspace;
import com.trelloclone.trelloclone.repositories.pm.WorkspaceRepository;
import com.trelloclone.trelloclone.services.auth.UserLogin;
import com.trelloclone.trelloclone.services.data.BoardDataService;
import com.trelloclone.trelloclone.services.data.WorkspaceDataService;

@Controller
public class DashboardController {

	@Autowired
	private WorkspaceRepository workspaceRepository;
	
	@Autowired
	private WorkspaceDataService workspaceDataService;
	
	@Autowired
	private BoardDataService boardDataService;
	
	private List<Workspace> workspaceCollection;
	
	@GetMapping("/dashboard")
	public String getDashboardPage(Model model) {

		this.workspaceCollection = this.workspaceDataService.getAllWorkspaces();
		model.addAttribute("collection", this.workspaceCollection);
		return "main/dashboard";
	}
	
	@GetMapping("/create-workspace")
	public String getCreateWorkspacePage(Model model) {

		if(this.workspaceCollection == null) {
			this.workspaceCollection = this.workspaceDataService.getAllWorkspaces();	
		}
		
		model.addAttribute("collection"	, this.workspaceCollection);
		model.addAttribute("workspace"	, new Workspace());
		return "main/create-workspace";
	}
	
	@PostMapping("/create-workspace")
	public RedirectView createWorkspace(@ModelAttribute Workspace entity) {

		this.workspaceDataService.createWorkspace(entity);
		return new RedirectView("/dashboard");
	}
	
	
	@GetMapping("/workspace/{id}/boards")
	public String getDashboardViewPage(@PathVariable int id, Model model) {
		
		if(this.workspaceCollection == null) {
			this.workspaceCollection = this.workspaceDataService.getAllWorkspaces();	
		}
		
		var boardCollection = this.boardDataService.getBoardsByWorkspace(id);
		
		model.addAttribute("workspaceCollection"	, this.workspaceCollection);
		model.addAttribute("boardCollection"		, boardCollection);
		model.addAttribute("workspaceId"			, id);
		
		return "main/boards-view";
	}
	
	@GetMapping("/workspace/{workspaceId}/boards/create")
	public String getDashboardCreatePage(@PathVariable int workspaceId, Model model) {
		
		if(this.workspaceCollection == null) {
			this.workspaceCollection = this.workspaceDataService.getAllWorkspaces();	
		}		
		
		model.addAttribute("workspaceId"			, workspaceId);
		model.addAttribute("workspaceCollection"	, this.workspaceCollection);
		model.addAttribute("boardModel"				, new Board());
		model.addAttribute("themeCollection"		, this.boardDataService.getAllThemes());
		
		return "main/create-board";
	}
	
	@PostMapping("/workspace/{workspaceId}/boards/create")
	public RedirectView createBoard(
			@PathVariable int workspaceId, 
			@ModelAttribute Board entity
	) {

		Board savedEntity = this.boardDataService.createBoard(entity, workspaceId);
		int entityId = savedEntity.getId().intValue();
		return new RedirectView("/boards/" + entityId);
	}
}
