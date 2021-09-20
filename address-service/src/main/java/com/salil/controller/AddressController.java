package com.salil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salil.request.CreateAddressRequest;
import com.salil.response.AddressResponse;
import com.salil.service.AddressService;

@RestController
@RequestMapping("/api/address")
@RefreshScope
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@Value("${address.testing}")
	private String test;
	
	@PostMapping("/create")
	public AddressResponse createStudent (@RequestBody CreateAddressRequest createStudentRequest) {
		return addressService.createAddress(createStudentRequest);
	}
	
	@GetMapping("/getById/{id}")
	public AddressResponse getById (@PathVariable long id) {
		return addressService.getById(id);
	}
	
	@GetMapping("/test")
	public String test() {
		return test;
	}
}
