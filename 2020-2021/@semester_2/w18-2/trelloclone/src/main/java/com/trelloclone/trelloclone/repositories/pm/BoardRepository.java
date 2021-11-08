package com.trelloclone.trelloclone.repositories.pm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trelloclone.trelloclone.models.pm.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
