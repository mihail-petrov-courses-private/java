package com.trelloclone.trelloclone.repositories.users;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trelloclone.trelloclone.models.users.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
