package com.assignments.assignment7.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.assignments.assignment7.models.MyUserDetails;
import com.assignments.assignment7.models.User;
import com.assignments.assignment7.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String userName) {
		//return new User("foo", "foo", new ArrayList<>());
		Optional<User> user = userRepository.findByUsername(userName);
		
		user.orElseThrow(() -> new UsernameNotFoundException("User not found " + userName));
		
		return user.map(MyUserDetails::new).get();
	}
//	public User save(MyUserDetails user) {
//		User newUser = new User();
//		newUser.(user.getUsername());
//		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//		return userDao.save(newUser);
//	}
}
