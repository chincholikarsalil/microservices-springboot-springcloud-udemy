package com.salil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salil.entity.Address;
import com.salil.repository.AddressRepository;
import com.salil.request.CreateAddressRequest;
import com.salil.response.AddressResponse;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {

		Address address = new Address();
		address.setStreet(createAddressRequest.getStreet());
		address.setCity(createAddressRequest.getCity());

		address = addressRepository.save(address);

		return new AddressResponse(address);
	}
	
	public AddressResponse getById (long id) {
		return new AddressResponse(addressRepository.findById(id).get());
	}
}
