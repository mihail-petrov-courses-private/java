package com.trelloclone.trelloclone.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.trelloclone.trelloclone.models.pm.Workspace;
import com.trelloclone.trelloclone.repositories.pm.WorkspaceRepository;
import com.trelloclone.trelloclone.services.auth.UserLogin;
import com.trelloclone.trelloclone.services.data.WorkspaceDataService;

@Controller
public class DashboardController {

	@Autowired
	private WorkspaceRepository workspaceRepository;
	
	@Autowired
	private WorkspaceDataService workspaceDataService;
	
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
	public RedirectView createWorkspace(
		@ModelAttribute Workspace entity,
		Authentication auth
	) {
		UserLogin authUser = (UserLogin)auth.getPrincipal();
	
		entity.setOwner(authUser.getUser());
		this.workspaceRepository.save(entity);
		return new RedirectView("/dashboard");
	}
}
