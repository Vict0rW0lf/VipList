package com.viplist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viplist.model.Guest;
import com.viplist.repository.GuestRepository;

@Service
public class GuestService {

	@Autowired
	private GuestRepository repository;
	
	public Iterable<Guest> findAll() {
		return repository.findAll();
	}
	
	public void save(Guest guest) {
		repository.save(guest);
	}
	
}
