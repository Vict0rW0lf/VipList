package com.viplist.repository;

import org.springframework.data.repository.CrudRepository;

import com.viplist.model.Guest;

public interface GuestRepository extends CrudRepository<Guest, Long> {

	
}
