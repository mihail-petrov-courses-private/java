package com.trelloclone.trelloclone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.trelloclone.trelloclone.models.Workspace;

public interface WorkspaceRepository extends JpaRepository<Workspace, Integer> {

}
