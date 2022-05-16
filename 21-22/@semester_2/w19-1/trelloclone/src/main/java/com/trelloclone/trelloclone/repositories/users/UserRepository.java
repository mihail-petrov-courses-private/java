package com.trelloclone.trelloclone.repositories.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trelloclone.trelloclone.models.users.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public Optional<User> findUserByEmailAndPassword(String email, String password);
	
	public Optional<User> findUserByEmail(String email);
	
}
