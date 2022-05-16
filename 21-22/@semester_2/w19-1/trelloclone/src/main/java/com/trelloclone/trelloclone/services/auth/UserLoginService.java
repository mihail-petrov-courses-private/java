package com.trelloclone.trelloclone.services.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.trelloclone.trelloclone.models.users.User;
import com.trelloclone.trelloclone.repositories.users.UserRepository;

@Service
public class UserLoginService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> dbEntry = this.userRepository.findUserByEmail(username);
		if(dbEntry.isEmpty()) {
			throw new UsernameNotFoundException("This user is not available");
		}
		
		return new UserLogin(dbEntry.get());
	}
}
