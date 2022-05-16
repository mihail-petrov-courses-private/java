package com.trelloclone.trelloclone.repositories.pm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trelloclone.trelloclone.models.pm.Card;

public interface CardRepository extends JpaRepository<Card, Integer> {

}
