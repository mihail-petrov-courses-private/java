package com.trelloclone.trelloclone.repositories.pm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trelloclone.trelloclone.models.pm.Workspace;

public interface WorkspaceRepository extends JpaRepository<Workspace, Integer> {
	
	public List<Workspace> getWorkspaceByOwnerId(long id);
}
