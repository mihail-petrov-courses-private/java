package com.trelloclone.trelloclone.repositories.pm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trelloclone.trelloclone.models.pm.BoardList;

public interface BoardListRepository extends JpaRepository<BoardList, Integer> {

	public List<BoardList> findAllByBoardId(int boardId);
}
