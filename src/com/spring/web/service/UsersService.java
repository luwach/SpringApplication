package com.spring.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.dao.User;
import com.spring.web.dao.UsersDao;

@Service("usersService")
public class UsersService {

	private UsersDao usersDao;

	@Autowired
	public void setOffersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public void create(User user) {
		usersDao.create(user);
	}
}
