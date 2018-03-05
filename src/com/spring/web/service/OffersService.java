package com.spring.web.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.spring.web.dao.Offer;
import com.spring.web.dao.OffersDao;

@Service("offersService")
public class OffersService {

	@Autowired
	private OffersDao offersDao;

	public List<Offer> getCurrent() {
		return offersDao.getOffers();
	}

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public void create(@Valid Offer offer) {
		offersDao.create(offer);
	}
}
