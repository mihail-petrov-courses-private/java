package com.trelloclone.trelloclone.repositories.pm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trelloclone.trelloclone.models.pm.Workspace;

public interface WorkspaceRepository extends JpaRepository<Workspace, Integer> {

}
