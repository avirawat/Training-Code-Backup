package com.security.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.model.AppUsers;
import com.security.repository.AppUsersRepository;

@Service
public class AppUsersServiceImpl implements UserDetailsService{

	private AppUsersRepository appUsersRepository;
	
	@Autowired
	public void setAppUsersRepository(AppUsersRepository appUsersRepository) {
		this.appUsersRepository = appUsersRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUsers appuser=appUsersRepository.findByUsername(username);
		if(appuser==null) {
			throw new UsernameNotFoundException("username not found");
		}
		String uname=appuser.getUsername();
		String password=appuser.getPassword();
		GrantedAuthority authorities=new SimpleGrantedAuthority("USER");
		
		User user=new User(uname,password,Arrays.asList(authorities));
		return user;
	}
	public AppUsers addUser(AppUsers user) {
		AppUsers appUsers=appUsersRepository.save(user);
		//System.out.println(appUsers);
		return appUsers;
	}
}
