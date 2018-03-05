package com.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.dao.User;
import com.spring.web.dao.UsersDao;

@Service("usersService")
public class UsersService {

	@Autowired
	private UsersDao usersDao;

	public void create(User user) {
		usersDao.create(user);
	}
	
	public boolean exists(String username) {
		return usersDao.exists(username);
	}

	public List<User> getAllUsers() {
		return usersDao.getAllUsers();
	}
}
