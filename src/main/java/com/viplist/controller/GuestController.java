package com.viplist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.viplist.model.Guest;
import com.viplist.service.GuestService;


@Controller
public class GuestController {
	
	@Autowired
	private GuestService service;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/guestlist")
	public String guestList(Model model) {
		Iterable<Guest> guests = service.findAll();
		
		model.addAttribute("guests", guests);
		
		return "guestlist";
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String Save(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("phone") String phone, Model model) {
		
		Guest guest = new Guest(name, email, phone);
		
		service.save(guest);
		
		Iterable<Guest> guests = service.findAll();
		
		model.addAttribute("guests", guests);
		
		return "guestlist";
	}
	
}
