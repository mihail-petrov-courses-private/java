package com.trelloclone.trelloclone.services.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.trelloclone.trelloclone.models.pm.Workspace;
import com.trelloclone.trelloclone.models.users.User;
import com.trelloclone.trelloclone.repositories.pm.WorkspaceRepository;
import com.trelloclone.trelloclone.services.auth.UserLogin;

import java.util.List;

@Component
public class WorkspaceDataService {

	@Autowired
	private WorkspaceRepository workspaceRepository;
	
	public List<Workspace> getAllWorkspaces() {
		
		Authentication auth 		= SecurityContextHolder.getContext().getAuthentication();
		UserLogin currentUserModel 	= (UserLogin)auth.getPrincipal();
		User currentUser 			= currentUserModel.getUser();
		
		return this.workspaceRepository.getWorkspaceByOwnerId(currentUser.getId());
	}	
}
